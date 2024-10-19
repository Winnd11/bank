package org.william.bank.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiError {
	String msg;
	
	public ResponseEntity<Object> sendError(String msg) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	}
}
