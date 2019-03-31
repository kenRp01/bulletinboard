package jp.co.board.service;

import jp.co.board.db.entity.LoginEntity;
import jp.co.board.db.mapper.MainMapper;
import jp.co.board.db.result.LoginResult;
import jp.co.board.exception.LoginException;
import jp.co.board.requestParam.TopParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class MainService {

    private final MainMapper mainMapper;

    public LoginResult checkPassword(TopParam topParam) throws LoginException {

        LoginEntity loginEntity = mainMapper.checkPassword(
                topParam.getUserName(),
                topParam.getPassword());

        if (ObjectUtils.isEmpty(loginEntity)) {
            throw new LoginException("ログインに失敗しました。");
        }
        return LoginResult.create(loginEntity);
    }

}
