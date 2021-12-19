package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userManager;

    @PostMapping("/register/{userName}{account}{password}{email}{phoneNumber}")
    public String register(@PathVariable("userName") String userName, @PathVariable("account") String account, @PathVariable("password") String password,
        @PathVariable("email") String email, @PathVariable("phoneNumber") String phoneNumber) {
        if (userManager.getUserPassword(account) == null) {
            userManager.pushUser(userName, account, password, email, phoneNumber);
            return "註冊成功";
        }
        return "註冊失敗";
    }

    @PostMapping("/logIn/{account}{password}")
    public String logIn(@PathVariable("account") String account, @PathVariable("password") String password) {
        String userName;
        if (userManager.getUserPassword(account) == null) {
            return "這帳號不存在";
        } else {
            int comp = password.compareTo(userManager.getUserPassword(account));
            if (comp != 0) {
                return "密碼錯誤";
            } else {
                userName = userManager.getUserName(account);
            }
        }
        return "Hello " + userName;
    }
}
