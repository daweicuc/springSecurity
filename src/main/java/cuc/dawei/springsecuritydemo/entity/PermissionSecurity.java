package cuc.dawei.springsecuritydemo.entity;

/**
 * @ClassName PermissionSecurity
 * @Description TODO
 * @Author Mike
 * @Date 2019/8/19 20:09
 * @Version 1.0
 */
public class PermissionSecurity {
    private int id;
    //权限名称
    private String name;
    //授权链接
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
