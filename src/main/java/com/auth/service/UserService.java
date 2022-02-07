package com.auth.service;

import java.util.List;

import com.auth.domain.Role;
import com.auth.domain.User;

public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getUsers();
}
