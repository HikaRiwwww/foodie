package com.throne.common.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5Utils {
    public static String getMd5str(String val){
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("系统错误");
        }
        return Base64.getEncoder().encodeToString(md5.digest(val.getBytes(StandardCharsets.UTF_8)));
    }
}
