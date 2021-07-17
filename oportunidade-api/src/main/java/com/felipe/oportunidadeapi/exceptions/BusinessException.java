package com.felipe.oportunidadeapi.exceptions;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BusinessException(String message) {
        super(message); // quem trata essa mensagem é classe pai (RuntimeException)
    }

}
