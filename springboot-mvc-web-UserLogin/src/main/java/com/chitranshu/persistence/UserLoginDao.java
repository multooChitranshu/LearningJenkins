package com.chitranshu.persistence;

import com.chitranshu.bean.User;

public interface UserLoginDao {
	User searchUser(String name);
}
