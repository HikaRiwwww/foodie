package com.throne.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.throne.pojo.Users;
import com.throne.pojo.bo.UserBO;

public interface UsersService extends IService<Users> {
    Boolean userNameExists(String username);

    Users createUser(UserBO userBO);

    Users queryUserForLogin(String username, String password);
}
