package jp.co.board.db.mapper;

import jp.co.board.db.entity.LoginEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface MainMapper {

    LoginEntity checkPassword(@Param("name") String userName, @Param("password") String password);
}
