package com.blog.jpablog.repository;

import com.blog.jpablog.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
