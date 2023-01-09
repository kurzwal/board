package com.yyr.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yyr.board.entity.MemberEntity;

// 해당 interface가 Repository임을 명시
@Repository
// Repository는 interface로 작성해야 함
// JpaRepository interface를 상속받아야 함
// JpaRepository<Table(EntityClass), (Primary key type)>
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
	
	// @Query 커스텀 ORM 메서드를 작성 가능 (쿼리문)
	// 테이블 명을 alias로 (예시 : m) 지정해서 사용 (* 못씀)
	// ?1, ?2, ... : 매개변수로 받아온 변수를 해당 위치로 넣기 위한 구문
	// (예시 : ?1에는 String email이 들어간다)
//	@Query("SELECT m FROM board.MEMBER m WHERE m.email = ?1")
//	public List<MemberEntity> myFindAll(String email);
}
