package cuc.dawei.springsecuritydemo.config;

import cuc.dawei.springsecuritydemo.until.MD5Util;
import org.springframework.security.crypto.password.PasswordEncoder;
//实现MD5的加密方式
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return MD5Util.encode((String)charSequence);
    }
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(MD5Util.encode((String)charSequence));
    }
}
