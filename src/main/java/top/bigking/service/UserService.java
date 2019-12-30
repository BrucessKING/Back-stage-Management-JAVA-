package top.bigking.service;

import top.bigking.model.User;

/**
 * @author: ABKing
 * @Date: 2019/12/29 10:17
 * @Description:
 **/
public interface UserService {
    /**
     * 根据用户名和密码查询用户
     */
    public User selectUserByUsernameAndPassword(String username, String password);
    /**
     * 根据用户id修改用户信息
     * @param user
     * @param id
     */
    public Integer updateUserById(User user, Integer id);
}
