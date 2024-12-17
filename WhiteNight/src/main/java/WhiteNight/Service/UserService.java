package WhiteNight.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiteNight.VO.UserVO;
import WhiteNight.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public void insertUser(UserVO userVO) {
		userDAO.insertUser(userVO); // 사용자등록
	}

	public UserVO getUserById(String userId) {
		return userDAO.selectUserById(userId); // 사용자 정보조회
	}

}
