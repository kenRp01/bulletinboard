package jp.co.board.db.entity;

import lombok.Data;

@Data
public class LoginEntity {
    private int Id;
    private String userName;
    private String Password;
}
