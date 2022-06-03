package com.blog.jpablog.board;

import com.blog.jpablog.entity.Board;
import com.blog.jpablog.entity.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BoardTests {
    @Autowired
    BoardRepository boardRepository;

    @Test
    void save() {
        Board params = Board.builder()
                .title("No.1 article")
                .content("No.1 content")
                .writer("test admin")
                .hits(0L)
                .deleteYn("N")
                .build();

        boardRepository.save(params);

        Board entity = boardRepository.findById((long) 1).get();
        assertThat(entity.getTitle()).isEqualTo("No.1 article");
        assertThat(entity.getContent()).isEqualTo("No.1 content");
        assertThat(entity.getWriter()).isEqualTo("test admin");
    }

    @Test
    void findAll() {
        long boardsCount = boardRepository.count();
        List<Board> boards = boardRepository.findAll();
    }

    @Test
    void delete() {
        Board entity = boardRepository.findById((long) 1).get();
        boardRepository.delete(entity);
    }
}