package jp.co.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LogoutController {
    @Autowired
    private HttpSession session;

    @PostMapping("/logout")
    public String logout(){

        session.getAttribute("loginUser");
        // セッションの無効化
        session.invalidate();

        return "redirect:/top";
    }
}
