package WhiteNight.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import WhiteNight.Service.FavoriteService;
import WhiteNight.Service.TaskService;
import WhiteNight.VO.FavoriteVO;
import WhiteNight.VO.TaskVO;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {

	@Autowired
	private FavoriteService favoriteService;

	@Autowired
	private TaskService taskService;

	// 기본 페이지 반환및 목록 반환
	@GetMapping("")
	public String favoritePage(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");

		if (userId == null) {
			return "redirect:/user/login"; // 로그인되지 않은 경우
		}

		try {
			List<FavoriteVO> favorites = favoriteService.getFavoritesWithTasks(userId);
			model.addAttribute("favorites", favorites); // 모델에 추가
			System.out.println("Favorites: " + favorites); // 디버깅 로그
		} catch (Exception e) {
			e.printStackTrace(); // 서버 콘솔에 에러 출력
			model.addAttribute("errorMessage", "데이터를 불러오는 중 오류가 발생했습니다.");
		}

		return "favorite"; // templates/favorite.html 반환
	}

	// 즐겨찾기 추가
	@PostMapping("/add")
	@ResponseBody
	public String addFavorite(HttpSession session, @RequestBody FavoriteVO favorite) {
	    String userId = (String) session.getAttribute("userId");
	    if (userId == null) {
	        return "로그인이 필요합니다.";
	    }

	    favorite.setUserId(userId); // 세션에서 사용자 ID 설정
	    favoriteService.addFavorite(favorite); // 즐겨찾기 추가만 수행

	    return "즐겨찾기에 추가되었습니다!";
	}

	// 즐겨찾기 및 테스크 조회
	@GetMapping("/tasks")
	public String getFavoritesWithTasks(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");
		List<FavoriteVO> favorites = favoriteService.getFavoritesWithTasks(userId);
		model.addAttribute("favorites", favorites);
		return "favorite"; // favorite.html 반환
	}

	// 테스크 추가
	@PostMapping("/task/add")
	public String addTask(@RequestBody TaskVO task) {
		taskService.addTask(task);
		return "테스크가 추가되었습니다!";
	}

}
