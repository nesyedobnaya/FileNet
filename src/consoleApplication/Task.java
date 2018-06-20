package consoleApplication;

import java.util.Date;

public class Task extends Document {
	
	Date deliveryDate;//дата выдачи поручения
	Date dueDate;//срок исполнения поручения   
	String executor;//ответственный исполнитель   
	String controleAttribute;//признак контрольности        
	String controller;//контролер поручения
    
	@Override
	public String toString() {
		return "Поручение № "+registrationNumber
			+ ", ID:  " + ID 
			+ ", Название документа: " + name 
			+ " Дата регистрации: " + registrationDate 
			+ ", Автор: " + author 
			+ ", Текст документа: "+ text 
			+ ", Дата выдачи: "+deliveryDate
			+ ", Срок исполнения: "+dueDate
			+ ", Ответственный исполнитель: "+executor				
			+ ", Статус: "+controleAttribute
			+ ", Контролер: "+controller;
	}
}
