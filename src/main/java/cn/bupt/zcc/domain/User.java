package cn.bupt.zcc.domain;

import java.io.Serializable;

/**
 * Created by 张城城 on 2018/5/12.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -1;
    private String username;
    private Integer age;
    public User(String username,Integer age){
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
