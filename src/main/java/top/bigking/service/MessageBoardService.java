package top.bigking.service;

import top.bigking.model.MessageBoard;

import java.util.List;

/**
 * @author: ABKing
 * @Date: 2019/12/29 16:34
 * @Description:
 **/
public interface MessageBoardService {
    /**
     * 查询所有留言信息
     */
    public List<MessageBoard> query();

    /**
     * 增加留言
     */
    public Integer addMessage(String nickname, String email, String content);

    /**
     * 删除留言
     */
    public Integer delMessage(Integer floor);
}
