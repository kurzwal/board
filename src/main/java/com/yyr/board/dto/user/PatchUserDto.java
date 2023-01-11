package com.yyr.board.dto.user;

import com.yyr.board.entity.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchUserDto {
	private String email;
	private String nickname;
	private String profile;
	
	public MemberEntity patchUser(MemberEntity member) {
		member.setNickname(nickname);
		member.setProfile(profile);
		return member;
	}
}
