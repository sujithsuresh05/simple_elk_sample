package com.simple.elk.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class NewsNotFoundException extends IllegalArgumentException {

    private final String searchText;

}
