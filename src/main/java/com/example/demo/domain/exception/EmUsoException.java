package com.example.demo.domain.exception;

public class EmUsoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmUsoException(String mensagem){
		super(mensagem);
	}

}
