package com.throne.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.throne.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper extends BaseMapper<Users> {
    Boolean userNameExists(@Param("username") String username);

    Users selectByUsernameAndPassword(
            @Param("username") String username,
            @Param("password") String password
    );
}