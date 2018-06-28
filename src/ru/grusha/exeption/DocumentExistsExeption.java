package ru.grusha.exeption;

public class DocumentExistsExeption extends Exception{     	
	
	/**
	 * 
	 * @param message - сообщение об ошибке
	 */
	public DocumentExistsExeption(String message){	   
		
		super(message);		    
	}	     	
}