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

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		DbCreator dbCreator = new DbCreator();
		dbCreator.createDB();
		Connection connection = dbCreator.getConnection();
		File filePeople = new File("D://XML/People2.xml");
		File fileOrganizations = new File("D://XML/Organizations2.xml");	 	    
		File fileDepartments = new File("D://XML/Departments2.xml");
		
		//загрузка из файлов	    
		FactoryUtil.loadedPeople=(People)JaxbParser.unMarshal(filePeople, People.class);				
		FactoryUtil.loadedDepartments=(Departments)JaxbParser.unMarshal(fileDepartments, Departments.class);			
		FactoryUtil.loadedOrganizations=(Organizations)JaxbParser.unMarshal(fileOrganizations, Organizations.class);
		
		dbCreator.insertPeople(FactoryUtil.loadedPeople);
		dbCreator.insertDepartments(FactoryUtil.loadedDepartments);
		dbCreator.insertOrganizations(FactoryUtil.loadedOrganizations);
		
		Statement statement = connection.createStatement();	
		ResultSet resultSet =statement.executeQuery("select * from Person");;
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		for (int x=1; x<=resultSetMetaData.getColumnCount();x++) System.out.format("%30s", resultSetMetaData.getColumnName(x)+ " | ");
		while (resultSet.next()){
			System.out.println();
			for (int x=1;x<=resultSetMetaData.getColumnCount();x++) System.out.format("%30s", resultSet.getString(x) + " | ");
		}
			
		ResultSet resultSet2 = statement.executeQuery("select * from Department");;
		ResultSetMetaData resultSetMetaData2 = resultSet2.getMetaData();
		for (int x=1; x<=resultSetMetaData2.getColumnCount();x++) System.out.format("%30s", resultSetMetaData2.getColumnName(x)+ " | ");
		while (resultSet2.next()){
			System.out.println();
			for (int x=1;x<=resultSetMetaData2.getColumnCount();x++) System.out.format("%30s", resultSet2.getString(x) + " | ");
		}
		
		ResultSet resultSet3 = statement.executeQuery("select * from Organization");;
		ResultSetMetaData resultSetMetaData3 = resultSet3.getMetaData();
		for (int x=1; x<=resultSetMetaData3.getColumnCount();x++) System.out.format("%30s", resultSetMetaData3.getColumnName(x)+ " | ");
		while (resultSet3.next()){
			System.out.println();
			for (int x=1;x<=resultSetMetaData3.getColumnCount();x++) System.out.format("%30s", resultSet3.getString(x) + " | ");
		}
	}
}
	

