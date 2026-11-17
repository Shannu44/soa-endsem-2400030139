package com.endexam.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endexam.soa.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
