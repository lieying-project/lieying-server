package org.lieying.dao;
import cn.pomit.jpamapper.core.mapper.CrudMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lieying.bean.Administrator;

public interface AdministratorMapper extends CrudMapper<Administrator,Integer> {

    Administrator selectAdministratorByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    Administrator selectDetailAdministratorById(int administratorId);

}
