package com.gym.gym.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.gym.domain.CustomUser;
import com.gym.gym.domain.TrainerProfile;
import com.gym.gym.domain.Users;
import com.gym.gym.service.AttendanceService;
import com.gym.gym.service.TrainerProfileService;
import com.gym.gym.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private TrainerProfileService trainerProfileService;

    /**
     * 메인 화면
     * 🔗 [GET] - /
     * 📄 index.html
     */
    @GetMapping("/")
    public String home(
            @AuthenticationPrincipal CustomUser authuser,
            Model model, HttpServletRequest request) throws Exception {

                // 출석 인원 조회 추가
                int result = attendanceService.listCount();
                model.addAttribute("result", result);

    if(authuser != null){
        jakarta.servlet.http.HttpSession session = request.getSession();
    
        log.info(":::::::::: 메인 화면 ::::::::::");
            Users user = authuser.getUser();
            model.addAttribute("user", user);
        

        if(authuser.getTrainerNo() > 0){
            log.info("sadaf" + authuser);
            TrainerProfile trainerProfile = trainerProfileService.selectTrainer(authuser.getTrainerNo());
            log.info(authuser.getTrainerNo() + "어써어디");
            session.setAttribute("trainerProfile", trainerProfile);
        }
            
    }

        return "index";
    }

    /**
     * 로그인 화면
     * 🔗 [GET] - /login
     * 📄 login.html
     */
    @GetMapping("/login")
    public String login(
            @CookieValue(value = "remember-id", required = false) Cookie cookie,
            Model model,
            HttpServletRequest request) {
        String username = "";
        boolean rememberId = false;
        if (cookie != null) {
            username = cookie.getValue();
            rememberId = true;
        }
        model.addAttribute("username", username);
        model.addAttribute("rememberId", rememberId);

        return "login";
    }

    /**
     * 회원 가입 화면
     * 🔗 [GET] - /join
     * 📄 join.html
     */
    @GetMapping("/join")
    public String join() {
        log.info(":::::::::: 회원 가입 화면 ::::::::::");
        return "join";
    }

    /**
     * 회원 가입 처리
     * 🔗 [POST] - /join
     */
    @PostMapping("/join")
    public String joinPro(Users user, HttpServletRequest request) throws Exception {
        log.info(":::::::::: 회원 가입 처리 ::::::::::");
        String plainPassword = user.getPassword();

        // 회원 가입 요청
        int result = userService.join(user);

        // 회원 가입 성공 시, 바로 로그인 처리
        if (result > 0) {
            user.setPassword(plainPassword); // 암호화 전 비밀번호로 로그인 처리
            boolean loginResult = userService.login(user, request);
            if (loginResult) {
                return "redirect:/";
            }
        }

        // 회원 가입 실패 시
        return "redirect:/join?error";
    }

    /**
     * 아이디 중복 검사
     * 🔗 [GET] - /check/{id}
     */
    @ResponseBody
    @GetMapping("/check/{id}")
    public ResponseEntity<Boolean> userCheck(@PathVariable("id") String id) throws Exception {
        log.info("아이디 중복 확인: " + id);
        Users user = userService.selectId(id);

        if (user != null) {
            log.info("중복된 아이디입니다: " + id);
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
