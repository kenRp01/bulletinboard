package jp.co.board.controller;

import jp.co.board.config.BoardConfig;
import jp.co.board.requestParam.TopParam;
import jp.co.board.service.TopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class TopController {
    private final TopService topService;
    private final BoardConfig boardConfig;
    private final HttpSession session;

    @GetMapping("/top")
    public String init(Model model,
                       @RequestParam(value = "topParam", required = false)TopParam topParam) {
        //セッションの初期化
        session.setAttribute("loginUser","");
        model.addAttribute("boardConfig", boardConfig);
        return "/top";
    }
}
