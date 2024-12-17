package WhiteNight.VO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserVO {
	
	private String userId;  // 사용자 ID
    private String email;   // 이메일
    private String password; // 비밀번호
    private LocalDateTime createdAt; // 생성 시간
    
}
