package cuc.dawei.springsecuritydemo.mapper;

import cuc.dawei.springsecuritydemo.entity.RoleSecurity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<RoleSecurity> findRolesByUser(@Param("name") String name);
}
