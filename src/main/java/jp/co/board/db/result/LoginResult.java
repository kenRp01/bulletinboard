package jp.co.board.db.result;

import jp.co.board.db.entity.LoginEntity;
import lombok.Value;

@Value
public class LoginResult {
    private int id;
    private String userName;
    private String password;

    public static LoginResult create(LoginEntity loginEntity) {
        return new LoginResult(
                loginEntity.getId(),
                loginEntity.getUserName(),
                loginEntity.getPassword()
        );
    }
}
