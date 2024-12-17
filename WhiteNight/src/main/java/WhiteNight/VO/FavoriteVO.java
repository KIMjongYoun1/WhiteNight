package WhiteNight.VO;

import java.util.List;

import lombok.Data;

@Data
public class FavoriteVO {
	
    private String favoriteId; // 즐겨찾기 ID
    private String userId;     // 사용자 ID
    private String quoteId;    // 문구 ID
    private String quoteText;  // 문구 내용 추가
    private List<TaskVO> tasks; // 관련 테스크 목록
}
