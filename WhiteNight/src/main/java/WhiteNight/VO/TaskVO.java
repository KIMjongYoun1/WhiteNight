package WhiteNight.VO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TaskVO {

    private String taskId;          // 체크리스트 ID
    private String userId;       // 사용자 ID
    private String quoteId;         // 문구 ID
    private String taskText;     // 체크리스트 내용
    private boolean completed;   // 완료 여부
    private LocalDateTime createdAt; // 생성 시간
	
}
