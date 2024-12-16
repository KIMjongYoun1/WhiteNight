package WhiteNight.VO;

import lombok.Data;

@Data
public class UserVO {
	
	private String userId;  // 사용자 ID
    private String email;   // 이메일
    private String password; // 비밀번호
	
}
