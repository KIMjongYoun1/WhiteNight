package WhiteNight.VO;

import lombok.Data;

@Data
public class FavoriteVO {
	
    private String favoriteId; // 즐겨찾기 ID
    private String userId;     // 사용자 ID
    private String quoteId;    // 문구 ID
	
}
