package com.yyr.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyr.board.dto.response.ResponseDto;
import com.yyr.board.dto.user.GetUserResponseDto;
import com.yyr.board.dto.user.PostUserDto;
import com.yyr.board.dto.user.PostUserResponseDto;
import com.yyr.board.entity.MemberEntity;
import com.yyr.board.repository.MemberRepository;

@Service
public class UserService {
	
	@Autowired MemberRepository memberRepository;
	
	public ResponseDto<PostUserResponseDto> postUser(PostUserDto dto) {
		String password = dto.getPassword();
		String password2 = dto.getPassword2();
		
		if (!password.equals(password2)) {
			return ResponseDto.setFailed("비밀번호가 서로 다릅니다.");
		}
		
		try {
			String email = dto.getEmail();
			if (memberRepository.existsById(email)) {
				return ResponseDto.setFailed("이미 가입된 이메일입니다.");
			}
		} catch (Exception e) {
			return ResponseDto.setFailed("데이터베이스 조회에 실패했습니다.");
		}
		
		
		MemberEntity member = MemberEntity.builder()
				.email(dto.getEmail())
				.password(dto.getPassword())
				.nickname(dto.getNickname())
				.telNumber(dto.getTelNumber())
				.address(dto.getAddress() + " " + dto.getAddressDetail()) 
				.build();
		
		memberRepository.save(member);
		
		return ResponseDto.setSuccess("회원가입에 성공했습니다.", new PostUserResponseDto(true));
	}
	
	public ResponseDto<GetUserResponseDto> getUser(String email) {
		MemberEntity member = findById(email);
		if (member == null) 
			return ResponseDto.setFailed("Not Exist User.");
		
		return ResponseDto.setSuccess("Get User Success", new GetUserResponseDto(member));
	}
	
	private MemberEntity findById(String email) {
		try {
			MemberEntity member = memberRepository.findById(email).get();
			return member;
		} catch (Exception e) {
			return null;
		}
	}
	
}
