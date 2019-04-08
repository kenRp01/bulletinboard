package jp.co.board.db.mapper;

import jp.co.board.db.entity.RegisterEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RegisterMapper {

    void checkRegister(@Param("userName") String userName, @Param("Password") String password);

    //ユーザー確認
    RegisterEntity checkUsers(@Param("userName") String userName);
}
