package jp.co.board.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginException extends Exception{
    //warningを回避するための宣言
    private static final long serialVersionUID = 1L;

    public LoginException(String msg){
        super(msg);
    }
}
