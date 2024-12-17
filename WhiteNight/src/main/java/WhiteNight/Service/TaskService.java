package WhiteNight.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiteNight.VO.TaskVO;
import WhiteNight.dao.TaskDAO;

@Service
public class TaskService {

	@Autowired
	private TaskDAO taskDAO;

	// 테스크 추가
	public void addTask(TaskVO task) {
		taskDAO.insertTask(task);
	}

	// 테스크 완료 상태 수정
	public void updateTaskCompletion(String taskId, boolean completed) {
	    taskDAO.updateTaskCompletion(taskId, completed);
	}

	// 특정 문구에 대한 테스크 조회
	public List<TaskVO> getTasksByQuoteId(String userId, int quoteId) {
		return taskDAO.selectTasksByQuoteId(userId, quoteId);
	}

}
