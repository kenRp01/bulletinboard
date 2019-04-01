package jp.co.board.db.mapper;

import jp.co.board.db.entity.RegisterEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RegisterMapper {

    RegisterEntity checkRegister(@Param("userName") String userName, @Param("Password") String password);
}