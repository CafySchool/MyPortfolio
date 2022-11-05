package it.its.atmapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DeleteFunctionalityException extends Exception{
	
	public DeleteFunctionalityException() {

		super("Impossibile cancellare la funzionalità");
	}
}
