package com.throne.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.throne.service.UsersService;
import com.throne.common.enums.SexEnum;
import com.throne.mapper.UsersMapper;
import com.throne.pojo.Users;
import com.throne.pojo.bo.UserBO;
import com.throne.common.utils.DateUtil;
import com.throne.common.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    private static final String DEFAULT_AVATAR = "https://inews.gtimg.com/newsapp_bt/0/13392595208/1000";

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Boolean userNameExists(String username) {
       return usersMapper.userNameExists(username);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {
        Users user = new Users();
        LocalDateTime now = LocalDateTime.now();
        user.setUsername(userBO.getUsername());
        user.setPassword(MD5Utils.getMd5str(userBO.getPassword()));
        user.setNickname(userBO.getUsername());
        user.setFace(DEFAULT_AVATAR);
        user.setBirthday(DateUtil.stringToDate("1900-01-01 00:00:00"));
        user.setSex(SexEnum.secret.type);
        user.setCreatedTime(now);
        user.setUpdatedTime(now);

        usersMapper.insert(user);
        return user;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {
        return usersMapper.selectByUsernameAndPassword(username, password);
    }


}
