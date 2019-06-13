package jp.co.board.service;

import jp.co.board.db.mapper.MessageMapper;
import jp.co.board.requestParam.MessageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    //メッセージチェック
    public boolean checkMessage(MessageParam messageParam) {
        if(StringUtils.isEmpty(messageParam.getMessage()) || StringUtils.isEmpty(messageParam
        .getCategory()) || StringUtils.isEmpty(messageParam.getTitle())){
            return true;
        }else{
            return false;
        }
    }

    //メッセージ追加
    public void addmessage(MessageParam messageParam) {
        messageMapper.addMessage(messageParam.getCategory(),
                messageParam.getTitle(),
                messageParam.getMessage());
    }
}
