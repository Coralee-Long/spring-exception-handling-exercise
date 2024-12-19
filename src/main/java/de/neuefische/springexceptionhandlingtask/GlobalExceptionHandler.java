package de.neuefische.springexceptionhandlingtask;

import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
@RestControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(NoSuchElementException.class)
	 @ResponseStatus(HttpStatus.NOT_FOUND) // Sends 404 status code
	 public ErrorMessage handleNoSuchElementException(NoSuchElementException e) {
			return new ErrorMessage(
					"GLOBAL: " + e.getMessage(),
					HttpStatus.NOT_FOUND,
					LocalDateTime.now());
	 }

	 @ExceptionHandler(Exception.class)
	 @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Sends 500 status code
	 public ErrorMessage handleGenericException(Exception e) {
			return new ErrorMessage(
					"GLOBAL: An unexpected error occurred: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR,
					LocalDateTime.now()
			);
	 }
}