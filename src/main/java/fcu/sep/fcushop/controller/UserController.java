package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.User;
import fcu.sep.fcushop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userManager;

    @GetMapping("/register/{data}")
    public String register(@PathVariable("data") String data) {
        String[] buf = data.split(",");
        User user;
        user = new User();
        for (User users : userManager.getUser(buf[1])) {
            user = users;
        }
        if (user.getName() == null) {
            userManager.pushUser(buf[0],buf[1], buf[2], buf[3], buf[4]);
            return "註冊成功";
        } else {
            return "此帳號已被使用";
        }
    }

    @GetMapping("/login/{data}")
    public String login(@PathVariable("data") String data) {
        String name, account, password;
        String[] buf;
        buf = data.split(",");
        account = buf[0];
        password = buf[1];
        User user;
        user = new User();
        for (User users : userManager.getUser(account)) {
            user = users;
        }
        if (user.getName() == null) {
            return "這帳號不存在";
        } else {
            int comp = password.compareTo(user.getPassword());
            if (comp != 0) {
                return "密碼錯誤";
            } else {
                name = user.getName();
            }
        }
        return "你好! " + name;
    }
}
