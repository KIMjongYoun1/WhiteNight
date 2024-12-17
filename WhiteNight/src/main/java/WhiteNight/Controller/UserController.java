package WhiteNight.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import WhiteNight.Service.UserService;
import WhiteNight.VO.UserVO;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 회원가입 페이지 반환
    @GetMapping("/register")
    public String registerPage() {
        return "register"; // templates/register.html 반환
    }

    // 회원가입 처리
    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserVO userVO) {
        userService.insertUser(userVO);
        return "redirect:/user/login"; // 회원가입 후 로그인 페이지로 이동
    }

    // 로그인 페이지 반환
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // templates/login.html 반환
    }

    // 로그인 처리
    @PostMapping("/login")
    public String loginUser(HttpSession session, @RequestParam String userId) {
        session.setAttribute("userId", userId); // 세션에 userId 저장
        return "redirect:/"; // 로그인 성공 후 홈으로 리다이렉트
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "redirect:/user/login"; // 로그인 페이지로 리다이렉트
    }

    // 유저 정보 페이지 반환
    @GetMapping("")
    public String userInfoPage(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("userId");
        if (userId != null) {
            UserVO user = userService.getUserById(userId);
            model.addAttribute("user", user);
        }
        return "user"; // templates/user.html 반환
    }
    
    // 유저 세션반환
    @GetMapping("/session")
    @ResponseBody
    public ResponseEntity<?> checkSession(HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        if (userId != null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    
}
