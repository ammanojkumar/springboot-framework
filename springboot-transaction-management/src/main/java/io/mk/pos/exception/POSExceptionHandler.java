package io.mk.pos.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class POSExceptionHandler {

	@ExceptionHandler(value = OutOfStockException.class)
	public ResponseEntity<ExceptionInfo> handleOutOfStockException(HttpServletRequest req, Exception e) {
		ExceptionInfo exceptionInfo = new ExceptionInfo(e.getMessage());
		ResponseEntity<ExceptionInfo> expInfo = new ResponseEntity<>(exceptionInfo, HttpStatus.INTERNAL_SERVER_ERROR);
		return expInfo;
	}

	@ExceptionHandler(value = InsufficientBalanceException.class)
	public ResponseEntity<ExceptionInfo> handleInsufficientBalanceException(HttpServletRequest req, Exception e) {
		ExceptionInfo exceptionInfo = new ExceptionInfo(e.getMessage());
		ResponseEntity<ExceptionInfo> expInfo = new ResponseEntity<>(exceptionInfo, HttpStatus.INTERNAL_SERVER_ERROR);
		return expInfo;
	}
}
