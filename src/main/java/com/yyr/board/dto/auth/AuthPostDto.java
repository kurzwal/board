package com.yyr.board.dto.auth;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthPostDto {
	
	// mvn - gradle - Bean Validation API 적용
	// @Email : 해당 값이 email인지 검증하는 어노테이션
	@Email
	private String email;
	private String password;
}
