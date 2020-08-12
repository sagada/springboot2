package com.example.demo;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberRole;
import com.example.demo.repository.MemberRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@Log
@SpringBootTest
@Commit
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testInsert()
    {
        Member member = new Member();
        for(int i = 0; i <=100;i++)
        {
            member.setUid("user" + i);
            member.setUpw("pw"+i);
            member.setUname("사용자"+i);

            MemberRole memberRole = new MemberRole();
            if(i <= 80)
            {
                memberRole.setRoleName("BASIC");
            }
            else if(i <= 90)
            {
                memberRole.setRoleName("MANAGER");
            }
            else
            {
                memberRole.setRoleName("ADMIN");
            }

            member.setRoles(Arrays.asList(memberRole));
            memberRepository.save(member);
        }
    }

    @Test
    public void testRead()
    {
        Optional<Member> result = memberRepository.findById("user85");
        result.ifPresent(member->{
            log.info("member"+ member);
        });
    }



}
