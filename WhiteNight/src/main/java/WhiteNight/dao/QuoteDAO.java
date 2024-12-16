package WhiteNight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import WhiteNight.VO.QuoteVO;

@Mapper
public interface QuoteDAO {

	 void insertQuote(QuoteVO quote);                  // 문구 추가
	    QuoteVO selectRandomQuote();                      // 랜덤 문구 조회
	    List<QuoteVO> selectQuotesByCategory(String category); // 카테고리별 문구 조회
	
}
