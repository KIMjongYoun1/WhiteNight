package WhiteNight.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiteNight.VO.QuoteVO;
import WhiteNight.dao.QuoteDAO;

@Service
public class QuoteService {

    @Autowired
    private QuoteDAO quoteDAO;

    public QuoteVO getRandomQuote() {
        return quoteDAO.selectRandomQuote();
    }
	
}
