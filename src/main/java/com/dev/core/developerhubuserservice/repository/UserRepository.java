package com.dev.core.developerhubuserservice.repository;

import com.dev.core.developerhubuserservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
