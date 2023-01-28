package com.throne.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户注册对象")
public class UserBO {
    @ApiModelProperty(value = "用户名", name = "用户名", example = "Tom")
    private String username;

    @ApiModelProperty(value = "密码", name = "密码")
    private String password;

    @ApiModelProperty(value = "密码确认", name = "密码确认")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
