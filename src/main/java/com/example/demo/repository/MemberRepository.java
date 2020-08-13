package com.example.demo.repository;

import com.example.demo.domain.Board;
import com.example.demo.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
    @Query("SELECT b FROM Board b")
    Page<Board> getBoardList(Pageable pageble);
}
