package com.blog.jpablog.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Invalid Request"),
    POSTS_NOT_FOUND(HttpStatus.NOT_FOUND, "NO ARTICLE FOUND"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "UNALLOWED METHOD"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL SERVER ERROR"),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "NO COMMENT FOUND"),
    ;
    private final HttpStatus status;
    private final String message;
}
