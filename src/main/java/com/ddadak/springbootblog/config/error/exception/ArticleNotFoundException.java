package com.ddadak.springbootblog.config.error.exception;

import com.ddadak.springbootblog.config.error.ErrorCode;

public class ArticleNotFoundException extends NotFoundException {
    public ArticleNotFoundException() {
        super(ErrorCode.ARTICLE_NOT_FOUND);
    }
}
