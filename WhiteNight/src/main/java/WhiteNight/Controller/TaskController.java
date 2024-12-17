package WhiteNight.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import WhiteNight.Service.TaskService;
import WhiteNight.VO.TaskVO;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	// 기본 페이지 반환
	@GetMapping("")
	public String taskPage() {
		return "task"; // templates/task.html 반환
	}

	// 테스크 추가
	@PostMapping("/add")
	@ResponseBody
	public String addTask(@RequestParam String quoteId, @RequestParam String taskText, HttpSession session) {
	    String userId = (String) session.getAttribute("userId");
	    System.out.println("Session UserId: " + userId); // 디버깅 로그
	    System.out.println("Received QuoteId: " + quoteId);
	    System.out.println("Received TaskText: " + taskText);

	    if (userId == null) {
	        return "로그인이 필요합니다.";
	    }

	    TaskVO task = new TaskVO();
	    task.setTaskId(UUID.randomUUID().toString());
	    task.setUserId(userId);
	    task.setQuoteId(quoteId);
	    task.setTaskText(taskText);
	    task.setCompleted(false);

	    taskService.addTask(task);
	    return "테스크가 추가되었습니다!";
	}


	// 테스크 완료 상태 수정
	@PostMapping("/update/{taskId}")
	@ResponseBody
	public String updateTaskStatus(@PathVariable String taskId, @RequestParam boolean completed) {
	    try {
	        taskService.updateTaskCompletion(taskId, completed);
	        return "상태 업데이트 성공!";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "상태 업데이트 실패!";
	    }
	}


	// 특정 문구에 대한 테스크 조회
	@GetMapping("/{userId}/{quoteId}")
	public String getTasksByQuoteId(@PathVariable int quoteId, HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/user/login"; // 로그인 안된 경우
		}
		List<TaskVO> tasks = taskService.getTasksByQuoteId(userId, quoteId);
		model.addAttribute("tasks", tasks);
		model.addAttribute("quoteId", quoteId);
		return "task"; // templates/task.html 반환
	}

}
