package WhiteNight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import WhiteNight.VO.TaskVO;

@Mapper
public interface TaskDAO {

	void insertTask(TaskVO task); // 체크리스트 추가

	// 특정 문구에 대한 체크리스트 조회
	List<TaskVO> selectTasksByQuoteId(String userId, int quoteId);

	// 체크리스트 완료 여부 수정
	void updateTaskCompletion(@Param("taskId") String taskId, @Param("completed") boolean completed);

}
