package com.example.oasis.data.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.oasis.po.User;

@Mapper
public interface UserServiceMapper {
    /**
     * 创建一个新的账号
     * @param username
     * @param password
     * @return
     */
    public int createNewAccount(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查找账号
     * @param username
     * @return
     */
    public User getAccountByName(@Param("username") String username);

    /**
     * 修改密码
     * @param username
     * @param password
     * @return
     */
    public int changePassword(@Param("username") String username, @Param("password") String password);

    /**
     * 删除账号
     * @param username
     * @return
     */
    public void delete(@Param("username") String username);


}
