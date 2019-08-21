package cuc.dawei.springsecuritydemo.mapper;

import cuc.dawei.springsecuritydemo.entity.PermissionSecurity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName PermissionMapper
 * @Description TODO
 * @Author Mike
 * @Date 2019/8/19 20:10
 * @Version 1.0
 */
@Mapper
public interface PermissionMapper {
    @Select("SELECT * from menu")
    public List<PermissionSecurity> findAll();
    @Select("select m.* from user u\n" +
            "left join user_role ur on u.id=ur.user_id\n"+
            "left join role r on ur.role_id=r.id\n"+
            "left join role_menu rm on rm.role_id=r.id\n"+
            "left join menu m on m.id=rm.menu_id\n"+
            "where u.id=#{userid}"
    )
    public List<PermissionSecurity> findByAdminUserId(@Param("userid") int userId);
}
