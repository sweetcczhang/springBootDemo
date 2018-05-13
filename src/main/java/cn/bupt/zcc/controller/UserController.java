package cn.bupt.zcc.controller;

import cn.bupt.zcc.exceptions.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张城城 on 2018/5/12.
 */

@RestController
public class UserController {

    @RequestMapping("/hello")
    public String index(){
        return "zcc";
    }

    @RequestMapping("/error")
    public String json() throws MyException{
        throw new MyException("测试url请求错误");
    }
}
