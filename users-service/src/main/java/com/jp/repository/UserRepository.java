package com.jp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	 Optional<UserEntity> findByEmail(String email);

}
