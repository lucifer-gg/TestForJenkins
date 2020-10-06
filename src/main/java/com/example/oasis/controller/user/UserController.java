package com.example.oasis.controller.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.oasis.vo.ResponseVO;
import com.example.oasis.vo.UserForm;
import com.example.oasis.vo.UserVO;
import com.example.oasis.blImpl.user.UserServiceImpl;

import javax.servlet.http.HttpSession;
@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserForm userForm, HttpSession session){
        UserVO user = userService.login(userForm);
        if(user==null) {
            return ResponseVO.buildFailure("用户名或密码错误");
        }
        //注册session
        session.setAttribute("user",userForm);
        return ResponseVO.buildSuccess(user);
    }
    @PostMapping("/register")
    public ResponseVO registerAccount(@RequestBody UserForm userForm){
        return userService.registerAccount(userForm);
    }

    @PostMapping("/logout")
    public ResponseVO logOut(HttpSession session){
        session.removeAttribute("user");
        return ResponseVO.buildSuccess();
    }

    @PostMapping("/changePassword")
    public ResponseVO changePassword(@RequestBody UserForm userForm, HttpSession session){
        return  userService.changepassword(userForm);
    }
}

