package com.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auth.domain.Role;
import com.auth.domain.User;
import com.auth.repo.RoleRepo;
import com.auth.repo.UserRepo;

@Service
@Transactional
// @RequiredArgsConstructor Lombok
//@Slf4j Lombok
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public User saveUser(User user) {
		System.out.println("Saving new to the databas");
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public User getUser(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

}
