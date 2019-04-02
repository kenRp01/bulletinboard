package jp.co.board.service;

import jp.co.board.db.entity.RegisterEntity;
import jp.co.board.db.mapper.RegisterMapper;
import jp.co.board.db.result.RegisterResult;
import jp.co.board.exception.RegisterException;
import jp.co.board.requestParam.RegisterParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterMapper registerMapper;

    //既存ユーザー確認
    public RegisterEntity checkUsers(RegisterParam registerParam) {
        RegisterEntity registerEntity = registerMapper.checkUsers(registerParam.getUserName());
        return registerEntity;
    }

    public RegisterResult checkRegister(RegisterParam registerParam) throws RegisterException {

        RegisterEntity registerEntity = (RegisterEntity) registerMapper.checkRegister(
                registerParam.getUserName(),
                registerParam.getPassword());

        if (ObjectUtils.isEmpty(registerEntity)) {
            try {
                throw new RegisterException("このユーザーは登録できません");
            } catch (RegisterException e) {
                e.printStackTrace();
            }
        }
        return RegisterResult.create(registerEntity);
    }

}