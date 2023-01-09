package com.yyr.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyr.board.dto.response.ResponseDto;
import com.yyr.board.dto.user.DeleteUserDto;
import com.yyr.board.dto.user.PostUserDto;
import com.yyr.board.dto.user.PostUserResponseDto;
import com.yyr.board.service.UserService;

@RestController
@RequestMapping("api/user/")
public class UserController {
	
	@Autowired UserService userService;
	
	@PostMapping("")
	public ResponseDto<PostUserResponseDto> postUser(@RequestBody PostUserDto requestBody) {
		return userService.postUser(requestBody);
	}
	
//	@DeleteMapping("")
//	public ResponseDto<PostUserResponseDto> deleteUser(@RequestBody DeleteUserDto requestBody) {
//		return userService.deleteUser(requestBody);
//	}
}
