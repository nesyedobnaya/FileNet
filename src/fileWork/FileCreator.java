package fileWork;

import java.io.File;

public class FileCreator {
	
	public static void main(String[] args) {
				
		Person person = new Person();
		person.setLastName("Никифоров");
		person.setFirstName("Виктор");
		person.setPatronymic("Николаевич");
		person.setPosition("Главный бухгалтер");
        
		JaxbParser parser = new JaxbParser();
		File file = new File("D://XML/Person.xml");
        parser.saveObject(file, person);
        
		Person loadPerson = (Person) parser.loadObject(file, Person.class);
		System.out.println("Фамилия: " + loadPerson.lastName + " Имя: " + loadPerson.firstName 
				+ " Отчество: " + loadPerson.patronymic + " Должность: " + loadPerson.position);
        
		Organization organization = new Organization();
		organization.setFullName("Уфимский государственный авиационный технический университет");
		organization.setShortName("УГАТУ");
		organization.setChief("Николай Константинович Криони");
		organization.setTelephone("8-917-752-27-29");
                
		File file2 = new File("D://XML/Organization.xml");
        parser.saveObject(file2, organization);
        
		Organization loadOrganization = (Organization) parser.loadObject(file2, Organization.class);
		System.out.println(loadOrganization.fullName + " Сокращенно: " + loadOrganization.shortName 
				+ " Руководитель: " + loadOrganization.chief + " Контактный телефон: " + loadOrganization.telephone);
		
		Department department=new Department();
		department.setFullName("Отдел стратегического развития предприятия");
		department.setShortName("Отдел развития");
		department.setChief("Решетников Василий Евгеньевич");
		department.setTelephone("8-919-619-01-86");
		
		File file3 = new File("D://XML/Department.xml");
        parser.saveObject(file3, department);
        
		Department loadDepartment = (Department) parser.loadObject(file3, Department.class);
		System.out.println(loadDepartment.fullName + " Сокращенно: " + loadDepartment.shortName 
				+ " Руководитель: " + loadDepartment.chief + " Контактный телефон: " + loadDepartment.telephone);
	}	
}
