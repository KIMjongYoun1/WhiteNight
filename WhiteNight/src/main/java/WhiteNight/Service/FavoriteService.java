package WhiteNight.Service;

import java.util.List;

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
		// quoteId를 사용해서 quoteText를 데이터베이스에서 조회
		String quoteText = quoteDAO.selectQuoteTextById(favorite.getQuoteId());
		favorite.setQuoteText(quoteText); // 조회된 문구 내용 설정

		// 즐겨찾기 추가
		favoriteDAO.insertFavorite(favorite);
	}

	public List<FavoriteVO> getFavoritesWithTasks(String userId) {
		List<FavoriteVO> favorites = favoriteDAO.selectFavoritesWithTasks(userId);
		System.out.println("Retrieved Favorites: " + favorites);
		return favorites;
	}
}
