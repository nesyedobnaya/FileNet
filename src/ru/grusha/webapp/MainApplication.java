package ru.grusha.webapp;

import java.sql.SQLException;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ru.grusha.exeption.DocumentExistsExeption;
import ru.grusha.factory.Generator;
import ru.grusha.utils.DocumentType;
import ru.grusha.utils.FactoryUtil;

@ApplicationPath("/ecm")
public class MainApplication extends Application{

	public MainApplication() throws SQLException{
		FactoryUtil.loadStaff();
		FactoryUtil.saveStaffInDB();
		
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
