package top.bigking.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import top.bigking.model.User;

/**
 * @author: ABKing
 * @Date: 2019/12/29 10:18
 * @Description:
 **/
@Component
public interface UserMapper {
    /**
     * 根据用户名和密码查询用户
     */
    public User selectUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 修改用户信息
     * @param user
     * @param id
     */
    public Integer updateUserById(@Param("user") User user, @Param("id") Integer id);



}
