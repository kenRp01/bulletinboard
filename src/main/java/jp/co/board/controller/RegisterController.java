package jp.co.board.controller;

import jp.co.board.config.BoardConfig;
import jp.co.board.db.entity.RegisterEntity;
import jp.co.board.db.result.RegisterResult;
import jp.co.board.exception.RegisterException;
import jp.co.board.requestParam.RegisterParam;
import jp.co.board.requestParam.TopParam;
import jp.co.board.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;
    private final BoardConfig boardConfig;

    @PostMapping("/registerInit")
    public String init(Model model, @ModelAttribute TopParam topParam){

        model.addAttribute("boardConfig", boardConfig);

        return "/register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute RegisterParam registerParam) throws RegisterException {

        model.addAttribute("registerParam", registerParam);
        model.addAttribute("boardConfig", boardConfig);
            // ユーザーチェック
            RegisterEntity users = registerService.checkUsers(registerParam);

            if(users == null){
                //登録
                registerService.checkRegister(registerParam);
                return "/top";
            }else{
                model.addAttribute("errorMsg","このユーザーは登録できません");
                return "/register";
            }
    }
}