package cuc.dawei.springsecuritydemo.until;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName BCryptPasswordEncoderuntil
 * @Description TODO
 * @Author Mike
 * @Date 2019/8/17 22:40
 * @Version 1.0
 */
public class BCryptPasswordEncoderuntil {
    public static void main(String[] args) {
        String password="123456";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println(hashedPassword);
    }
}
