package ru.grusha.webapp;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.factory.Generator;
import ru.grusha.utils.DocumentType;
import ru.grusha.utils.FactoryUtil;

@ApplicationPath("/appl")
public class MainApplication extends Application{

	public MainApplication(){
		FactoryUtil.loadStaff();
		
		Generator generator = new Generator();
		for (DocumentType type : DocumentType.values()) { 
			try {
				generator.createDocument(type);
			}catch(DocumentExistsExeption ex){
				System.out.println(ex.getMessage());	
			}
		}	
	}
}
