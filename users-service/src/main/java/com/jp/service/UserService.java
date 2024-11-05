package com.jp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.dto.UserDetailsRequest;
import com.jp.dto.UserDetailsResponse;
import com.jp.entity.UserEntity;
import com.jp.exception.UsernameNotFoundException;
import com.jp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public UserDetailsResponse createUser(UserDetailsRequest userDetailsRequest) {
		UserEntity userEntity = mapper.map(userDetailsRequest, UserEntity.class);
		UserEntity savedUserEntity = userRepository.save(userEntity);
		return mapper.map(savedUserEntity, UserDetailsResponse.class);
	}
	
	public UserDetailsResponse getUser(String email) {
		UserEntity existingUser = userRepository.findByEmail(email)
			.orElseThrow(()->new UsernameNotFoundException(String.format("Missing email :%s", email)));
		return mapper.map(existingUser, UserDetailsResponse.class); 
	}

}
