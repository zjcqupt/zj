package com.zj.DAO;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zj.entities.User;

/*
 * 注意mapper是和dao对应的，没有放在同一文件夹下，可以通过全局配置mapper
 */

public interface UserDAO {
	public User SelectUserByid(int id);
	public List<User>SelectUserByName(@Param("name")String name);
}
