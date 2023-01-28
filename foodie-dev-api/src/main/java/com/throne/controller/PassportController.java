package com.throne.controller;

import com.throne.service.UsersService;
import com.throne.pojo.Users;
import com.throne.pojo.bo.UserBO;
import com.throne.common.utils.CommonResp;
import com.throne.common.utils.CookieUtils;
import com.throne.common.utils.JsonUtils;
import com.throne.common.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "用户账户管理", tags = {"登录注册"})
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UsersService usersService;

    @ApiOperation(value = "判断用户名是否存在", notes = "判断用户名是否存在", httpMethod = "GET")
    @GetMapping("/isUserExists")
    public CommonResp usernameIsExist(@RequestParam String username){
        if (StringUtils.isBlank(username)){
            return CommonResp.errorMsg("用户名不能为空");
        }
        Boolean exists = usersService.userNameExists(username);
        return exists ? CommonResp.errorMsg("用户名已存在"): CommonResp.ok();
    }

    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/register")
    public CommonResp register(@RequestBody UserBO userBO, HttpServletRequest request, HttpServletResponse response){
        if(StringUtils.isBlank(userBO.getUsername()) ||
                StringUtils.isBlank(userBO.getPassword()) ||
                StringUtils.isBlank(userBO.getConfirmPassword())){
            return CommonResp.errorMsg("用户名或密码不能为空");
        }

        if (userBO.getPassword().length() < 6){
            return CommonResp.errorMsg("密码长度不能少于6位");
        }

        if(!userBO.getPassword().equals(userBO.getConfirmPassword())){
            return CommonResp.errorMsg("两次输入密码不一致");
        }

        Boolean userExists = usersService.userNameExists(userBO.getUsername());
        if (userExists){
            return CommonResp.errorMsg("用户名已存在");
        }
        Users user = usersService.createUser(userBO);
        user = setNullProperty(user);
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(user), true);
        return CommonResp.ok(user);
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public CommonResp login(@RequestBody UserBO userBO, HttpServletRequest request, HttpServletResponse response){
        String username = userBO.getUsername();
        String password = userBO.getPassword();

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return CommonResp.errorMsg("用户名或密码不能为空");
        }

        Users user = usersService.queryUserForLogin(username, MD5Utils.getMd5str(password));
        if (null == user){
            return CommonResp.errorMsg("用户名或密码错误");
        }
        user = setNullProperty(user);
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(user), true);
        return CommonResp.ok(user);
    }

    private Users setNullProperty(Users user){
        user.setRealname(null);
        user.setPassword(null);
        user.setMobile(null);
        user.setEmail(null);
        return user;
    }
}
