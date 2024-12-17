package WhiteNight.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiteNight.VO.FavoriteVO;
import WhiteNight.dao.FavoriteDAO;
import WhiteNight.dao.QuoteDAO;

@Service
public class FavoriteService {

	@Autowired
	private FavoriteDAO favoriteDAO;

	@Autowired
	private QuoteDAO quoteDAO;

	public void addFavorite(FavoriteVO favorite) {
	    // favoriteId에 UUID 설정
	    favorite.setFavoriteId(UUID.randomUUID().toString());

	    // tasks 필드를 null로 초기화
	    favorite.setTasks(null); 

	    // quoteText 조회
	    String quoteText = quoteDAO.selectQuoteTextById(favorite.getQuoteId());
	    favorite.setQuoteText(quoteText);

	    // 즐겨찾기 추가
	    favoriteDAO.insertFavorite(favorite);
	}

	public List<FavoriteVO> getFavoritesWithTasks(String userId) {
		List<FavoriteVO> favorites = favoriteDAO.selectFavoritesWithTasks(userId);
		System.out.println("Retrieved Favorites: " + favorites);
		return favorites;
	}
}
