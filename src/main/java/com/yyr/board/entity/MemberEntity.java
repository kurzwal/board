package com.yyr.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// 엔티티로 쓸 때 다는 어노테이션(@Service 같은애임)
// 인자로 Entity의 이름을 지정할 수 있음
@Entity(name="MEMBER")
// 해당 Entity 클래스와 데이터베이스 Table을
// 인자로 지정한 이름으로 매핑
@Table(name = "MEMBER")
public class MemberEntity {
	
	@Id					// Primary key 어노테이션
//	@GeneratedValue		// 해당 Primary key의 value 자동 생성
	private String email;
	private String password;
	private String nickname;
	private String profile;
	private String telNumber;
	private String address;
}
