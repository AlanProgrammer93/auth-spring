package com.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
