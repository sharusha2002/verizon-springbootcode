package com.waleed.training;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/")
    String getMessage(){
        return "Hello everyone";
    }

    @RequestMapping("/users")
    String getUserMessage(){
        return "Hello User, you are now logged in...";
    }

    @RequestMapping("/admin")
    String getAdminMessage(){
        return "Hi Admin.";
    }



}
