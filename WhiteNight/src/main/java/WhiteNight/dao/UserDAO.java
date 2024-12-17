package WhiteNight.dao;

import org.apache.ibatis.annotations.Mapper;

import WhiteNight.VO.UserVO;

@Mapper
public interface UserDAO {

    void insertUser(UserVO user);                // 사용자 등록
    boolean checkUserIdExists(String userId);    // 사용자 ID 중복 확인
	
    UserVO selectUserById(String userId);		// 사용자 정보 조회
    
}
