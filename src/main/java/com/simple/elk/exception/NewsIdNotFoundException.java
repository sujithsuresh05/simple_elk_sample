package com.simple.elk.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class NewsIdNotFoundException extends IllegalArgumentException {

    private final String newsId;

}
