package WhiteNight.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import WhiteNight.Service.QuoteService;
import WhiteNight.VO.QuoteVO;

@Controller
public class QuoteController {
	
	@Autowired
    private QuoteService quoteService;

    @GetMapping("/") // 홈 페이지 반환
    public String quotePage() {
        return "quote"; // templates/quote.html 반환
    }

    @GetMapping("/quote/random") // 랜덤 문구 반환 (AJAX 요청)
    @ResponseBody
    public QuoteVO getRandomQuote() {
        return quoteService.getRandomQuote();
    }
	
}
