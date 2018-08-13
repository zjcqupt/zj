package com.zj.DAO;

import org.apache.ibatis.annotations.Param;
import com.zj.entities.Account;

public interface AccountDAO {
	
	public void insert(@Param("record")Account record);
	public Account  select(@Param("name")String userName);
	
}
