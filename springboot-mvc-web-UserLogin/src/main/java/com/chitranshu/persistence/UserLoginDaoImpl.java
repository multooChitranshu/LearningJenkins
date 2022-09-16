package com.chitranshu.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chitranshu.bean.User;
import com.chitranshu.persistence.helper.UserRowMapper;

@Repository
public class UserLoginDaoImpl implements UserLoginDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public User searchUser(String name) {
		User user=null;
		try {
		String query="SELECT * FROM USERS where NAME=?";
		user=jdbcTemplate.queryForObject(query, new UserRowMapper(), name);
		}
		catch(EmptyResultDataAccessException ex) {
			return user;
		}
		return user;
	}
	
}
