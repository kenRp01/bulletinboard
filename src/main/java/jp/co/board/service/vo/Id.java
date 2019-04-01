package jp.co.board.service.vo;

import lombok.Value;

@Value
public class Id {
    public String value;

    public static Id of(String value) {
        return Id.of(value);
    }
}
