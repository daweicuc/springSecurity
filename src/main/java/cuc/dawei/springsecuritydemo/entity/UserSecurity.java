package cuc.dawei.springsecuritydemo.entity;

import java.util.List;

/**
 * @ClassName UserSecurity
 * @Description TODO
 * @Author Mike
 * @Date 2019/8/19 20:08
 * @Version 1.0
 */
public class UserSecurity {
    private int id;
    private String username;
    private String password;
    private List<RoleSecurity> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<RoleSecurity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleSecurity> roles) {
        this.roles = roles;
    }
}
