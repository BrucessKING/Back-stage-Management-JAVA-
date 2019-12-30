package top.bigking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.bigking.common.MD5;
import top.bigking.model.User;
import top.bigking.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: ABKing
 * @Date: 2019/12/29 10:28
 * @Description:
 **/
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "auth", method = RequestMethod.POST)
    public String auth(HttpSession session, String username, String password) throws IOException {
        logger.info("username:" + username + "  password:" + password);
        User user = userService.selectUserByUsernameAndPassword(username, password);
        if(user != null){
            session.setAttribute("user", user);
            return "main";
        }
        return "login";
    }
    @RequestMapping("myInfo")
    public String myInfo(){
        return "myInfo";
    }
    @PostMapping("changeInfo")
    @ResponseBody
    public String changeInfo(HttpSession session, String password , String picSrc){
        User user = (User) session.getAttribute("user");
        if(!password.equals(""))
            user.setPassword(MD5.getMD5Str(password).toLowerCase());
        user.setImg(picSrc);
        logger.info(picSrc);
        logger.info(user.getId().toString());
        Integer result  = userService.updateUserById(user, user.getId());
        if(result == 1)
            return "success!";
        else
            return "failed!";
    }

}
