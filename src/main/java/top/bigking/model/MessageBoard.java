package top.bigking.model;


import java.io.Serializable;
import java.util.Date;

/**
 * @author: ABKing
 * @Date: 2019/12/29 16:31
 * @Description:
 **/
public class MessageBoard implements Serializable {
    private Integer floor;
    private String author;
    private String email;
    private String content;

    private Date messageDate;

    public MessageBoard() {
    }

    public MessageBoard(String author, String email, String content, Date messageDate) {
        this.author = author;
        this.email = email;
        this.content = content;
        this.messageDate = messageDate;
    }


    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }
}
