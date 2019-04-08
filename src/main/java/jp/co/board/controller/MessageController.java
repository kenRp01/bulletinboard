package jp.co.board.controller;

import jp.co.board.config.BoardConfig;
import jp.co.board.requestParam.MessageParam;
import jp.co.board.requestParam.TopParam;
import jp.co.board.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.standard.expression.MessageExpression;

@Controller
@RequiredArgsConstructor
public class MessageController {
    @Autowired
    private final MessageService messageService;
    private final BoardConfig boardConfig;

    @PostMapping("/messageInit")
    public String init(Model model, @ModelAttribute TopParam topParam){
        model.addAttribute("boardConfig",boardConfig);
        return "/message";
    }
    @PostMapping("/message")
    public String message(Model model,@ModelAttribute MessageParam messageParam) {
        model.addAttribute("messageParam",messageParam);
        model.addAttribute("boardConfig",boardConfig);
        //メッサージチェック
        boolean message = messageService.checkMessage(messageParam);
        if(message){
            messageService.addmessage(messageParam);
            return "/main";
        }else{
            model.addAttribute("errorMsg","このメッセージは登録できません");
            return "/message";
        }
    }
}
