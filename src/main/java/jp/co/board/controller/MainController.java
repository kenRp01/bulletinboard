package jp.co.board.controller;

import jp.co.board.config.BoardConfig;
import jp.co.board.db.result.LoginResult;
import jp.co.board.exception.LoginException;
import jp.co.board.requestParam.TopParam;
import jp.co.board.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;
    private final BoardConfig boardConfig;

    @PostMapping("/main")
    public String init(Model model, @ModelAttribute TopParam topParam) throws LoginException {

        model.addAttribute("topParam", topParam);
        model.addAttribute("boardConfig", boardConfig);
        try {
            // ユーザーチェック
            LoginResult result = mainService.checkPassword(topParam);
            model.addAttribute("loginResult", result);
        } catch (LoginException e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "/top";
        }
        return "/main";
    }
}
