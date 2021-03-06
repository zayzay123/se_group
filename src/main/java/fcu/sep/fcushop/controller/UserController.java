package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.User;
import fcu.sep.fcushop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private User user;

    @Autowired
    UserService userManager;

    @GetMapping("/register/{data}")
    public String register(@PathVariable("data") String data) {
        String[] buf = data.split(",");
        user = new User();
        for (User users : userManager.getUser(buf[1])) {
            user = users;
        }
        if (user.getName() == null) {
            userManager.pushUser(buf[0],buf[1], buf[2], buf[3], buf[4]);
            for (User users : userManager.getUser(buf[1])) {
                user = users;
            }
            return "註冊成功";
        } else {
            user = null;
            return "此帳號已被使用";
        }
    }

    @GetMapping("/login")
    public User getUser() {
        return user;
    }

    @GetMapping("/login/{data}")
    public String login(@PathVariable("data") String data) {
        String name, account, password;
        String[] buf;
        buf = data.split(",");
        account = buf[0];
        password = buf[1];
        user = new User();
        for (User users : userManager.getUser(account)) {
            user = users;
        }
        if (user.getName() == null) {
            user = null;
            return "這帳號不存在";
        } else {
            int comp = password.compareTo(user.getPassword());
            if (comp != 0) {
                user = null;
                return "密碼錯誤";
            } else {
                name = user.getName();
            }
        }
        return "你好! " + name;
    }

    @GetMapping("/logout")
    public void logout() {
        user = null;
    }
}
