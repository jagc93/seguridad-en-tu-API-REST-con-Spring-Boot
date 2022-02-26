package com.openwebinars.rest.security.jwt.model;

import java.util.Set;

import com.openwebinars.rest.users.dto.GetUserDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtUserResponse extends GetUserDTO {

	private String token;

	@Builder(builderMethodName = "jwtUserResponseBuilder")
	public JwtUserResponse(String username, String avatar, String fullname, String email, Set<String> roles, String token) {
		super(username, avatar, fullname, email, roles);
		this.token = token;
	}

}
