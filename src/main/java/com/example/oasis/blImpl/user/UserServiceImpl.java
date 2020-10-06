package com.example.oasis.blImpl.user;

import com.example.oasis.vo.ResponseVO;
import com.example.oasis.vo.UserForm;
import com.example.oasis.vo.UserVO;
import com.example.oasis.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.oasis.bl.user.UserService;
import com.example.oasis.data.user.UserServiceMapper;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private  UserServiceMapper userMapper;

    //创建新账号，失败就是已存在
    @Override
    public ResponseVO registerAccount(UserForm userForm){
        try {
            userMapper.createNewAccount(userForm.getUsername(), userForm.getPassword());
        } catch (Exception e) {
            return ResponseVO.buildFailure("账号已存在");
        }
        return ResponseVO.buildSuccess();
    }

    //登录
    @Override
    public UserVO login(UserForm userForm){
        User user = userMapper.getAccountByName(userForm.getUsername());
        if (null == user || !user.getPassword().equals(userForm.getPassword())) {
            return null;
        }
        return new UserVO(user);
    }

    //修改密码
    @Override
    public ResponseVO changepassword(UserForm userForm){
        try {
            User user = userMapper.getAccountByName(userForm.getUsername());
            if (null == user) {
                return ResponseVO.buildFailure("无此名称的账号");
            }
            userMapper.changePassword(userForm.getUsername(), userForm.getPassword());
        } catch (Exception e) {
            return ResponseVO.buildFailure("修改失败");
        }
        return ResponseVO.buildSuccess();
    }

    //删除账户
    @Override
    public ResponseVO delete(UserForm userForm){
        userMapper.delete(userForm.getUsername());
        return ResponseVO.buildSuccess();

    }
}
