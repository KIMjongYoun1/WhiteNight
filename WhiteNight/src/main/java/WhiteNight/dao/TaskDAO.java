package WhiteNight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import WhiteNight.VO.TaskVO;

@Mapper
public interface TaskDAO {

	  void insertTask(TaskVO task);                   // 체크리스트 추가
	    void updateTaskCompletion(int taskId, boolean completed); // 체크리스트 완료 여부 수정
	    List<TaskVO> selectTasksByQuoteId(String userId, int quoteId); // 특정 문구에 대한 체크리스트 조회
	
}
