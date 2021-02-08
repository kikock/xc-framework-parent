package com.xuecheng.framework.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @project_name: xc-framework-utils
 * @description: 加密工具
 * @create_name: kikock
 * @create_date: 2021/1/1 11:09
 */
public class BCryptUtil {
    public static String encode(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashPass = passwordEncoder.encode(password);
        return hashPass;
    }

    public static boolean matches(String password, String hashPass) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean f = passwordEncoder.matches(password, hashPass);
        return f;
    }
}
