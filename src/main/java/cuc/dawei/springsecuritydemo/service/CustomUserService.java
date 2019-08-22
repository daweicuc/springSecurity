package cuc.dawei.springsecuritydemo.service;

import cuc.dawei.springsecuritydemo.entity.PermissionSecurity;
import cuc.dawei.springsecuritydemo.entity.UserSecurity;
import cuc.dawei.springsecuritydemo.mapper.PermissionMapper;
import cuc.dawei.springsecuritydemo.mapper.RoleMapper;
import cuc.dawei.springsecuritydemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CustomUserService
 * @Description TODO
 * @Author Mike
 * @Date 2019/8/19 20:11
 * @Version 1.0
 */
@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        获取用户的信息
        UserSecurity user=userMapper.findByUserName(username);
//        获取用户的权限等信息
        if(user!=null){
            List<PermissionSecurity> permissions=permissionMapper.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
            for(PermissionSecurity permission:permissions){
                if(permission!=null&&permission.getName()!=null){
                    GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            System.out.println("用户名："+user.getUsername()+"  密码："+user.getPassword()+"权限："+grantedAuthorities);
            return new User(user.getUsername(),user.getPassword(),grantedAuthorities);
        }else{
            throw new UsernameNotFoundException("admin"+username+"do not exist!");
        }

    }
}
