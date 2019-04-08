package jp.co.board.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MessageException extends Exception{
    //warningを回避するための宣言
    private static final long serialVersionUID = 1L;

    public MessageException(String msg) {
        super(msg);
    }
}
