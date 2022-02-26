package com.openwebinars.rest.users.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openwebinars.rest.users.dto.CreateUserDTO;
import com.openwebinars.rest.users.dto.GetUserDTO;
import com.openwebinars.rest.users.dto.UserDTOConverter;
import com.openwebinars.rest.users.model.UserEntity;
import com.openwebinars.rest.users.services.UserEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserEntityService userEntityService;
	private final UserDTOConverter userDTOConverter;
	
	@PostMapping("/")
	public GetUserDTO nuevoUsuario(@RequestBody CreateUserDTO newUser) {
			return userDTOConverter.convertUserEntityToGetUserDto(userEntityService.nuevoUsuario(newUser));
	}
	
	@GetMapping("/me")
	public GetUserDTO yo(@AuthenticationPrincipal UserEntity user) {
		return userDTOConverter.convertUserEntityToGetUserDto(user);
	}
}
