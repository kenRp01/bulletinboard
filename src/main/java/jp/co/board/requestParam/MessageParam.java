package jp.co.board.requestParam;

import lombok.Data;

@Data
public class MessageParam {
    private String category;
    private String title;
    private String message;

}
