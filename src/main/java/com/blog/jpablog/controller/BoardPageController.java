package com.blog.jpablog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardPageController {
    @GetMapping("/list")
    public String openBoardList() {
        return "board/list";
    }

    @GetMapping("/new")
    public String openBoardWrite() {
        return "board/new";
    }
}
