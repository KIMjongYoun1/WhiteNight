package WhiteNight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import WhiteNight.VO.FavoriteVO;

@Mapper
public interface FavoriteDAO {

	void insertFavorite(FavoriteVO favorite);         // 즐겨찾기 추가
    void deleteFavorite(String favoriteId);           // 즐겨찾기 삭제
    List<FavoriteVO> selectFavoritesWithTasks(String userId); // 즐겨찾기 + 테스크 조회
	
}
