package com.yyr.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yyr.board.entity.MemberEntity;

public interface UserRepository extends JpaRepository<MemberEntity, String> {
	
}
