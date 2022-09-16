package com.chitranshu.persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chitranshu.bean.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("userId");
		String name=rs.getString("name");
		String password=rs.getString("password");
		return new User(id,name,password);
	}

}
