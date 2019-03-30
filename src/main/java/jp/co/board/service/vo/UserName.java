package jp.co.board.service.vo;

import lombok.Value;

@Value
public class UserName {
    private String value;

    public static Password of(String value) {
        return Password.of(value);
    }
}
