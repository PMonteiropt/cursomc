package com.everis.cursomc.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.everis.cursomc.services.exceptions.ObjectNotFoundEception;

@ControllerAdvice
public class ResourceExceptionHandler {

		
		
		@ExceptionHandler(ObjectNotFoundEception.class)//Tratador de excepçoes da classe ObjectNotFound
		public ResponseEntity<StandardError> objectNotFound (ObjectNotFoundEception e,HttpServletRequest request) {//Padrão de Controller advice. Classe que interpecta
																													//excepçao
												//Gera Erro 404                /Mensagem da Excepçao   //Hota actual do sistema
			StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		}


}
