package com.simple.elk.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IndexNameNullException extends IllegalArgumentException {
	
	public IndexNameNullException(String s) {
        super(s);
    }
}
