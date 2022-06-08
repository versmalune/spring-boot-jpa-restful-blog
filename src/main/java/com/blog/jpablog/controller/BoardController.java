package com.blog.jpablog.controller;

import com.blog.jpablog.model.dto.BoardDto;
import com.blog.jpablog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/")
    public Long save(@RequestBody final BoardDto boardDto) {
        return boardService.save(boardDto);
    }

    @GetMapping("/")
    public List<BoardDto> findAll() {
        return boardService.findAll();
    }

    @PutMapping("/{id}")
    public Long save(@PathVariable final Long id, @RequestBody final BoardDto boardDto) {
        return boardService.update(id, boardDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id) {
        boardService.delete(id);
    }
}
