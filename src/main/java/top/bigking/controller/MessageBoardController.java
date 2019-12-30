package top.bigking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.bigking.model.MessageBoard;
import top.bigking.service.MessageBoardService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: ABKing
 * @Date: 2019/12/29 16:25
 * @Description:
 **/
@Controller
public class MessageBoardController {
    @Autowired
    private MessageBoardService messageBoardService;
    private Logger logger = LoggerFactory.getLogger(MessageBoardController.class);

    @RequestMapping("messageBoard")
    public String messageBoard(HttpSession session){
        List<MessageBoard> messageBoards = messageBoardService.query();
        session.setAttribute("messageBoards", messageBoards);
        return "messageBoard";
    }
    @PostMapping("addMessage")
    @ResponseBody
    public String addMessage(String nickname, String email, String content){
        Integer result = messageBoardService.addMessage(nickname, email, content);
        logger.info("nickname: " + nickname + "email: " + email + "content: " + content);
        logger.info(result.toString());
        if(result == 1)
            return "success";
        else
            return "failed";
    }
    @PostMapping("delMessage")
    @ResponseBody
    public String delMessage(Integer floor){
        logger.info(floor.toString());
        Integer result = messageBoardService.delMessage(floor);
        if(result == 1)
            return "success";
        else
            return "failed";
    }
}
