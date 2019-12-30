package top.bigking.model;

import java.io.Serializable;

/**
 * @author: ABKing
 * @Date: 2019/12/29 10:22
 * @Description:
 **/
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String img;

    public User() {
    }

    public User(String username, String password, String img) {
        this.username = username;
        this.password = password;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

