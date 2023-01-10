package com.yyr.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyr.board.dto.auth.AuthPostDto;
import com.yyr.board.dto.auth.LoginDto;
import com.yyr.board.dto.response.ResponseDto;
import com.yyr.board.entity.MemberEntity;
import com.yyr.board.repository.MemberRepository;

// @Service : 해당 클래스가 Service 레이어 역할을 함 (딱히 기능 없음)
@Service
public class AuthService {
	
	@Autowired MemberRepository memberRepository;
	
	public ResponseDto<LoginDto> login(AuthPostDto dto) {
		// 입력받은 email 으로 데이터베이스에서 검색
		// 존재하지 않는다면 없는 아이디이므로 "로그인 실패" 반환
		String email = dto.getEmail();
		MemberEntity member;
		try {
			member = memberRepository.findById(email).get();
		} catch (Exception e) {
			return ResponseDto.setFailed("Login Failed");
		}
		
		// 존재한다면 입력받은 패스워드와 데이터베이스의 패스워드와 동일한지 검사
		// 동일하지 않다면 "로그인 실패" 반환
		String password = dto.getPassword();
		String savedPassword = member.getPassword();
		if (!password.equals(savedPassword))
			return ResponseDto.setFailed("Login Failed");
		
		// 토큰 생성 후 토큰 및 만료시간 반환
		LoginDto result = new LoginDto("TOKEN", 3600000);
		return ResponseDto.setSuccess("로그인 성공", result);
	}

	
	
	public String hello() {
		// Entity Class로 entity 빌드
		MemberEntity memberEntity = MemberEntity
				.builder()
				.email("asdf@asdf.com")
				.password("1234")
				.nickname("asdf")
				.telNumber("010-1234-1234")
				.address("busan")
				.build();
		// 빌드한 Entity를 DB에 저장
		memberRepository.save(memberEntity);
		
		// MemberRepository가 상속받은 JpaRepository 메서드를 사용하여 데이터 검색
		MemberEntity savedMemberEntity = memberRepository.findById("asdf@asdf.com").get();

		// MemberRepository에 작성한 커스텀 메서드(@Query)를 사용
//		List<MemberEntity> list = memberRepository.myFindAll("asdf@asdf.com");
//		System.out.println(list.toString());
		
		return savedMemberEntity.getNickname();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String register(MemberEntity memberEntity) {
		memberRepository.save(memberEntity);
		return "Regist complete!";
	}
	
	public String getNicknameByEmail(String email) {
		MemberEntity savedMemberEntity = memberRepository.findById(email).get();
		return savedMemberEntity.getNickname();
	}
	
	public String deleteByEmail(String email) {
		memberRepository.deleteById(email);
		return "Delete complete!";
	}
	
}
