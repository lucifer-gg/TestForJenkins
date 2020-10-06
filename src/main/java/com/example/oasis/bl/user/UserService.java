package com.example.oasis.bl.user;
import  com.example.oasis.vo.*;


public interface UserService {
    /**
     * 注册账号
     * @return
     */
    public ResponseVO registerAccount(UserForm userForm);

    /**
     * 用户登录，登录成功会将用户信息保存再session中
     * @return
     */
    public UserVO login(UserForm userForm);

    /**
     * 用修改用户，只限定用户的密码
     * @return
     */
    public ResponseVO changepassword(UserForm userForm);

    /**
     * 删除用户
     * @return
     */
    public ResponseVO delete(UserForm userForm);
}
