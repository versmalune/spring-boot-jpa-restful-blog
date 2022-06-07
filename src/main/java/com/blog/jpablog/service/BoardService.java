package com.blog.jpablog.service;

import com.blog.jpablog.exception.CustomException;
import com.blog.jpablog.exception.ErrorCode;
import com.blog.jpablog.model.Board;
import com.blog.jpablog.model.dto.BoardDto;
import com.blog.jpablog.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long save(final BoardDto boardDto) {
        Board board = boardRepository.save(boardDto.toEntity());
        return board.getId();
    }

    public List<BoardDto> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id", "createdDate");
        List<Board> list = boardRepository.findAll(sort);
        return list.stream().map(BoardDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Long update(final Long id, final BoardDto boardDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        board.update(boardDto.getTitle(), boardDto.getContent(), boardDto.getWriter());
        return id;
    }
}
