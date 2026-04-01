package com.grantserve.grantserve1.repository;

import com.grantserve.grantserve1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
