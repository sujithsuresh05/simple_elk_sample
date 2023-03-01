package com.simple.elk.exception;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionHandlerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);

	@ExceptionHandler(NewsIdNotFoundException.class)
	public ResponseEntity<Object> handleNewsIdNotFoundException(NewsIdNotFoundException ex, HttpServletResponse res)
			throws IOException {
		LOGGER.error("Invalid news id", ex);
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public void handleException(Exception ex, HttpServletResponse res) throws IOException {
		LOGGER.error("Handled Internal Error Exception", ex);
		res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong");
	}

}
