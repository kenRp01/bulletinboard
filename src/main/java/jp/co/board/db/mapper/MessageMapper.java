package jp.co.board.db.mapper;

import jp.co.board.db.entity.LoginEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface MessageMapper {

    void addMessage(@Param("category") String category, @Param("title") String title, @Param("message") String message);
}
