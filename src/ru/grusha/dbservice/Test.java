package ru.grusha.dbservice;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import ru.grusha.utils.FactoryUtil;
import ru.grusha.utils.JaxbParser;
import ru.grusha.wrappers.Departments;
import ru.grusha.wrappers.Organizations;
import ru.grusha.wrappers.People;

/**
 * 
 * @author nesyedobnaya
 * класс для создания документов различных типов и вывода в консоль и в JSON файл отчета о созданных документах
 */
public class Test {

	public static final String SQL_SELECT_ALL_FROM_PERSON = "select * from Person"; 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		DbCreator dbCreator = new DbCreator();
		dbCreator.createDB();
		Connection connection = dbCreator.getConnection(DbCreator.JDBC_URL);
		File filePeople = new File("D://XML/People2.xml");
		File fileOrganizations = new File("D://XML/Organizations2.xml");	 	    
		File fileDepartments = new File("D://XML/Departments2.xml");
		
		//загрузка из файлов	    
		FactoryUtil.loadedPeople=(People)JaxbParser.unMarshal(filePeople, People.class);				
		FactoryUtil.loadedDepartments=(Departments)JaxbParser.unMarshal(fileDepartments, Departments.class);			
		FactoryUtil.loadedOrganizations=(Organizations)JaxbParser.unMarshal(fileOrganizations, Organizations.class);
		
		dbCreator.insertPeople(FactoryUtil.loadedPeople);
		dbCreator.insertPeople(FactoryUtil.loadedPeople);
		
		Statement statement = connection.createStatement();	
		ResultSet resultSet =statement.executeQuery(SQL_SELECT_ALL_FROM_PERSON);;
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		for (int x=1; x<=resultSetMetaData.getColumnCount();x++) System.out.format("%30s", resultSetMetaData.getColumnName(x)+ " | ");
		while (resultSet.next()){
			System.out.println();
			for (int x=1;x<=resultSetMetaData.getColumnCount();x++) System.out.format("%30s", resultSet.getString(x) + " | ");
		}
	}
}
	

