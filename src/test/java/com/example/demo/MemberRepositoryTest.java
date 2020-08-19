package com.example.demo;

import com.example.demo.domain.Member;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @Transactional
    public void testInsert()
    {
        Member member = new Member();
        member.setId("이효리");
        member.setPassword(passwordEncoder.encode("manstqw"));
        member.setName("이효리");
        member.setRole(Role.ROLE_MANAGER);
        member.setEnabled(true);
        memberRepository.save(member);


        Member member2 = new Member();
        member2.setId("유재석");
        member2.setPassword(passwordEncoder.encode("manstqw"));
        member2.setName("유재석");
        member2.setRole(Role.ROLE_MANAGER);
        member2.setEnabled(true);
        memberRepository.save(member2);

        for (int i = 1; i <= 13; i++)
        {
            Board board = new Board();
            board.setMember(member);
            board.setTitle(member.getName() + "가 등록한 게시글 "+ i);
            board.setContent(member.getName() + " 가 등록한 게시글" + i );
            boardRepository.save(board);
        }

        for (int i = 1; i <= 13; i++)
        {
            Board board = new Board();
            board.setMember(member2);
            board.setTitle(member2.getName() + "가 등록한 게시글 "+ i);
            board.setContent(member2.getName() + " 가 등록한 게시글" + i );
            boardRepository.save(board);
        }
    }


}
