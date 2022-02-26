package com.openwebinars.rest.security.jwt;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openwebinars.rest.security.jwt.model.JwtUserResponse;
import com.openwebinars.rest.security.jwt.model.LoginRequest;
import com.openwebinars.rest.users.dto.GetUserDTO;
import com.openwebinars.rest.users.dto.UserDTOConverter;
import com.openwebinars.rest.users.model.UserEntity;
import com.openwebinars.rest.users.model.UserRole;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider tokenProvider;
	private final UserDTOConverter converter;

	@PostMapping("auth/login")
	public ResponseEntity<JwtUserResponse> login(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserEntity user = (UserEntity) authentication.getPrincipal();
		String jwtToken = tokenProvider.generateToken(authentication);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(convertUserEntityAndTokenToJwtUserResponse(user, jwtToken));
	}

	public GetUserDTO me(@AuthenticationPrincipal UserEntity user) {
		return converter.convertUserEntityToGetUserDto(user);
	}

	private JwtUserResponse convertUserEntityAndTokenToJwtUserResponse(UserEntity user, String jwtToken) {
		return JwtUserResponse
				.jwtUserResponseBuilder()
				.fullname(user.getFullName())
				.email(user.getEmail())
				.username(user.getUsername())
				.avatar(user.getAvatar())
				.roles(user.getRoles().stream().map(UserRole::name).collect(Collectors.toSet()))
				.token(jwtToken)
				.build();
	}
}
