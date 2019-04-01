package jp.co.board.controller;

import jp.co.board.config.BoardConfig;
import jp.co.board.db.result.RegisterResult;
import jp.co.board.exception.RegisterException;
import jp.co.board.requestParam.RegisterParam;
import jp.co.board.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterContriller {
    private final RegisterService registerService;
    private final BoardConfig boardConfig;

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute RegisterParam registerParam) throws RegisterException {

        model.addAttribute("registerParam", registerParam);
        model.addAttribute("boardConfig", boardConfig);
        try {
            // ユーザーチェック
            RegisterResult result = registerService.checkRegister(registerParam);
            model.addAttribute("registerResult", result);
        } catch (RegisterException e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "/register";
        }
        return "/top";
    }
}