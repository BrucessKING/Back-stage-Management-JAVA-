package top.bigking.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bigking.common.MD5;
import top.bigking.dao.UserMapper;
import top.bigking.model.User;
import top.bigking.service.UserService;

/**
 * @author: ABKing
 * @Date: 2019/12/29 10:17
 * @Description:
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectUserByUsernameAndPassword(String username, String password) {
        User user = userMapper.selectUserByUsernameAndPassword(username, MD5.getMD5Str(password).toLowerCase());
        return user;
    }

    @Override
    public Integer updateUserById(User user, Integer id) {
        int result = userMapper.updateUserById(user, id);
        return result;
    }
}
