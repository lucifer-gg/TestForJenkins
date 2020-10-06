package com.example.oasis.blImpl.user;

import com.example.oasis.vo.UserForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
//登陆的测试不要一起测试！！！需要按逻辑进行测试
//修改密码会影响数据库！谨慎测试
public class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
   @Test
   public void testloginsuccess(){
        //成功登陆，密码一样
       UserForm userForm=new UserForm();
       userForm.setPassword("123456");
        userForm.setUsername("admin");
     assertEquals("123456",userService.login(userForm).getPassword());

    }
    @Test
    public void testloginfailure(){
        //登陆失败
        UserForm userForm=new UserForm();
        userForm.setPassword("errorpassword");
        userForm.setUsername("admin");
        assertEquals(null,userService.login(userForm));
    }
    @Test
   public void testregister(){
       //注册成功
        UserForm userForm=new UserForm();
        userForm.setPassword("123456");
        userForm.setUsername("adminxxx");
        userService.registerAccount(userForm);
       assertEquals("123456",userService.login(userForm).getPassword());//注册完看能不能登录
       userService.delete(userForm);//测试完删除此账号
    }
    @Test
    public void testregisterfailure(){
        //注册账号失败 控制台会报错，账号已存在
       UserForm userForm=new UserForm();
       userForm.setPassword("123456");
        userForm.setUsername("admin");
        userService.registerAccount(userForm);
    }
    @Test
    public void testchangepassword(){
        //修改密码成功
        UserForm userForm=new UserForm();
        userForm.setPassword("1234567");
        userForm.setUsername("admin");
        userService.changepassword(userForm);
       assertEquals("1234567",userService.login(userForm).getPassword());
        userForm.setPassword("123456");
        userService.changepassword(userForm);//测试完恢复密码

    }
    @Test
    public void testchangepasswordfailure(){
        //修改密码失败 观察控制台输出 无此名称的账号
        UserForm userForm=new UserForm();
        userForm.setPassword("123456");
        userForm.setUsername("adminerror");
        userService.changepassword(userForm);
    }
}
