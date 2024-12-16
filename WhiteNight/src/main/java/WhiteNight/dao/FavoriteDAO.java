package WhiteNight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import WhiteNight.VO.FavoriteVO;

@Mapper
public interface FavoriteDAO {

	void insertFavorite(FavoriteVO favorite);         // 즐겨찾기 추가
    void deleteFavorite(String favoriteId);           // 즐겨찾기 삭제
    List<FavoriteVO> selectFavoritesByUser(String userId); // 특정 사용자의 즐겨찾기 조회
	
}
