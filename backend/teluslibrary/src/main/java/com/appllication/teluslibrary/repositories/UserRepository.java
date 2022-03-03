package com.appllication.teluslibrary.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appllication.teluslibrary.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findById(Long id);
}
