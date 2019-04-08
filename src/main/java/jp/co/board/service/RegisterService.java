package jp.co.board.service;

import jp.co.board.db.entity.RegisterEntity;
import jp.co.board.db.mapper.RegisterMapper;
import jp.co.board.requestParam.RegisterParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterMapper registerMapper;

    //既存ユーザー確認
    public RegisterEntity checkUsers(RegisterParam registerParam) {
        RegisterEntity registerEntity = registerMapper.checkUsers(registerParam.getUserName());
        return registerEntity;
    }

    public void checkRegister(RegisterParam registerParam) {
        registerMapper.checkRegister(
                registerParam.getUserName(),
                registerParam.getPassword());
    }
}