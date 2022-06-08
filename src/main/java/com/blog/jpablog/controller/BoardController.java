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

    @GetMapping("")
    public List<BoardDto> findAll() {
        return boardService.findAll();
    }

    @PostMapping("/new")
    public void save(@RequestBody final BoardDto boardDto) {
        boardService.save(boardDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable final Long id, @RequestBody final BoardDto boardDto) {
        boardService.update(id, boardDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id) {
        boardService.delete(id);
    }
}
