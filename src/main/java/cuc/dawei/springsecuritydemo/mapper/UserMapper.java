package cuc.dawei.springsecuritydemo.mapper;

import cuc.dawei.springsecuritydemo.entity.UserSecurity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select u.*,r.name from user u left join user_role ur on ur.user_id=u.id left join role r on ur.role_id=r.id where u.username=#{username}")
    UserSecurity findByUserName(@Param("username") String username);
}
