package de.neuefische.springexceptionhandlingtask;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorMessage(
		String message,
		HttpStatus status,
		LocalDateTime timestamp
) {

}
