package jp.co.board.db.result;

import jp.co.board.db.entity.LoginEntity;
import lombok.Value;

@Value
public class LoginResult {
    private int id;
    private String userName;

    public static LoginResult create(LoginEntity loginEntity) {
        return new LoginResult(
                loginEntity.getId(),
                loginEntity.getUserName()
        );
    }
}
