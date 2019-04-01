package jp.co.board.db.result;

import jp.co.board.db.entity.RegisterEntity;
import lombok.Value;

@Value
public class RegisterResult {
    private String userName;
    private String password;

    public static RegisterResult create(RegisterEntity registerEntity) {
        return new RegisterResult(
                registerEntity.getUserName(),
                registerEntity.getPassword()
        );
    }
}
