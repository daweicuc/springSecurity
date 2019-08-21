package cuc.dawei.springsecuritydemo.service;

import cuc.dawei.springsecuritydemo.entity.PermissionSecurity;
import cuc.dawei.springsecuritydemo.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @ClassName MyInvocationSecurityMetadataSourceService
 * @Description TODO
 * @Author Mike
 * @Date 2019/8/19 21:16
 * @Version 1.0
 */
@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private PermissionMapper permissionMapper;
    private HashMap<String,Collection<ConfigAttribute>> map=null;
    /**
     * 加载权限表中所有权限
     */
    public void loadResourceDefine(){
        map=new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        List<PermissionSecurity> permissions=permissionMapper.findAll();
        for(PermissionSecurity permission:permissions){
            array=new ArrayList<>();
            cfg=new SecurityConfig(permission.getName());
            array.add(cfg);
            map.put(permission.getUrl(),array);
        }


    }
    /**
     * 此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法， 用来判定用户
     * 是否有此权限。如果不在权限表中则放行。
     */

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if(map ==null){ loadResourceDefine();}
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if(matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
