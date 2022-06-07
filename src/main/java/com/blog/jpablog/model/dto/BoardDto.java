package com.blog.jpablog.model.dto;

import com.blog.jpablog.model.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Long hits;
    private String deleteYn;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Board toEntity() { //BoardRequestDto
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .hits(0L)
                .deleteYn(deleteYn)
                .build();
    }

    public BoardDto(Board board) { //BoardResponseDto
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
        this.hits = board.getHits();
        this.deleteYn = board.getDeleteYn();
        this.createdDate = board.getCreatedDate();
        this.modifiedDate = board.getModifiedDate();
    }
}
