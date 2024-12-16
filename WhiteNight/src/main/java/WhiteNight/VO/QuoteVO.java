package WhiteNight.VO;

import lombok.Data;

@Data
public class QuoteVO {
	
    private String quoteId;  // 문구 ID
    private String text;     // 동기부여 문구
    private String category; // 문구 카테고리 (예: 행복, 용기)
	
}
