package com.openwebinars.rest.users.dto;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.openwebinars.rest.users.model.UserEntity;
import com.openwebinars.rest.users.model.UserRole;

@Component
public class UserDTOConverter {

	public GetUserDTO convertUserEntityToGetUserDto(UserEntity user) {

		return GetUserDTO.builder()
				.username(user.getUsername())
				.avatar(user.getAvatar())
				.fullName(user.getFullName())
				.email(user.getEmail())
				.roles(user.getRoles().stream()
						.map(UserRole::name)
						.collect(Collectors.toSet())
						).build();
	}
}
