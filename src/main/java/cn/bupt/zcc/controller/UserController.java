package cn.bupt.zcc.controller;

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
}
