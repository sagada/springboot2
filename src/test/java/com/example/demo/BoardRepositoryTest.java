package com.example.demo;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testBGetBoard(){
        Board board= boardRepository.findById(1L).get();
        System.out.println(board);
    }
}
