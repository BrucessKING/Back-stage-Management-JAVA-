package top.bigking.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bigking.dao.MessageBoardMapper;
import top.bigking.model.MessageBoard;
import top.bigking.service.MessageBoardService;

import java.util.List;

/**
 * @author: ABKing
 * @Date: 2019/12/29 16:35
 * @Description:
 **/
@Service
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;
    @Override
    public List<MessageBoard> query() {
        List<MessageBoard> messageBoards = messageBoardMapper.query();
        return messageBoards;
    }

    @Override
    public Integer addMessage(String nickname, String email, String content) {
        Integer result = messageBoardMapper.addMessage(nickname, email, content);
        return result;
    }

    @Override
    public Integer delMessage(Integer floor) {
        Integer result = messageBoardMapper.delMessage(floor);
        return result;
    }
}
