package top.bigking.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import top.bigking.model.MessageBoard;

import java.util.List;

/**
 * @author: ABKing
 * @Date: 2019/12/29 16:26
 * @Description:
 **/
@Component
public interface MessageBoardMapper {
    /**
     * 查询所有留言
     */
    public List<MessageBoard> query();

    /**
     * 增加留言
     * @param nickname
     * @param email
     * @param content
     */
    public Integer addMessage(@Param("author") String nickname, @Param("email") String email, @Param("content") String content);

    /**
     * 删除留言
     * @param floor
     * @return
     */
    public Integer delMessage(@Param("floor") Integer floor);
}
