package io.mk.orm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ErrorResponse handleException(Exception ex) {
		return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
	}

	@ExceptionHandler(value = ItemAlreadyExistsException.class)
	public ErrorResponse handleItemAlreadyExistsException(ItemAlreadyExistsException ex) {
		return new ErrorResponse(HttpStatus.CONFLICT, ex.getMessage());
	}

	@ExceptionHandler(value = ItemNotFoundException.class)
	public ErrorResponse handleItemNotFoundException(ItemNotFoundException ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
	}

//	@ExceptionHandler(value = InvalidDataAccessResourceUsageException.class)
//	public ErrorResponse handleMethodArgumentNotValid(InvalidDataAccessResourceUsageException ex) {
//		return new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
//	}

}
