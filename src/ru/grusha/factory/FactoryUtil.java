package ru.grusha.factory;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import ru.grusha.model.Document;
import ru.grusha.model.Document.DocType;
import ru.grusha.model.Incoming;
import ru.grusha.model.Outgoing;
import ru.grusha.model.People;
import ru.grusha.model.Person;
import ru.grusha.model.Task;
import ru.grusha.storage.NameStorage;

public class FactoryUtil {
	
		static People people = new People();
			
		//генерация идентификатора
		public static void generateID(Document document){
			document.setID(String.format("%.0f%n",(Math.random()*10000)));    
		}
	     
		//случайный выбор автора документа
		public static void author(Document document){
			//document.setAuthor(NameStorage.author[new Random().nextInt(5)]);				
			Person p =NameStorage.loadedPeople.list.get(new Random().nextInt(NameStorage.loadedPeople.list.size()));
			document.setAuthor(p);		
		}
		
		//случайный выбор персона
		public static Person randomPerson(){							
			return NameStorage.loadedPeople.list.get(new Random().nextInt(NameStorage.loadedPeople.list.size()));	
		}
	        
		//метод для генерации случайных строк
		public static String generateString(int byteLength) {           	
			SecureRandom secureRandom = new SecureRandom();
			byte[] token = new byte[byteLength];
			secureRandom.nextBytes(token);
			return new BigInteger(1, token).toString(32);
		}
	           
		//генерация текста документа
		public static void text(Document document){
			document.setText(generateString(16));            
		}
	    
		//генерация регистрационного номера        
		public static void name(Document document){
			document.setName("Название документа");
		}
		
		//генерация случайной даты
		public static Date RandomDate() {            
			int year = ThreadLocalRandom.current().nextInt(100, 118);
			int month = ThreadLocalRandom.current().nextInt(0, 11);		
			int date = ThreadLocalRandom.current().nextInt(1, 30);
			return new Date(year, month, date);       
		}
	    
		//метод, возвращающий случайное число в заданном диапазоне
		public static int randBetween(int start, int end) {            
			return start + (int)Math.round(Math.random() * (end - start));        
		}
	    
		//генерация даты регистрации
		public static void registrationDate(Document document){
			document.setRegistrationDate(RandomDate());
		}
		
		//генерация регистрационного номера
		public static int createRegistrationNumber(){
			return (int)(Math.random()*1000000);			
		}		
		
		//генерация исходящей даты регистрации
		public static void makeOutgoingRegistrationDate(Incoming incoming){
			incoming.setOutgoingRegistrationDate(RandomDate());
		}
	    
		//генерация исходящего регистрационного номера
		public static void makeOutgoingNumber(Incoming incoming){
			incoming.setOutgoingNumber((int)(Math.random()*10000));
		}
	    
		//случайный выбор отправителя
		public static void makeSender(Incoming incoming){
			Person p =NameStorage.loadedPeople.list.get(new Random().nextInt(NameStorage.loadedPeople.list.size()));
			incoming.setAuthor(p);
		}
	    
		//случайный выбор адресата
		public static void makeAddressee(Incoming incoming){
			Person p =NameStorage.loadedPeople.list.get(new Random().nextInt(NameStorage.loadedPeople.list.size()));
			incoming.setAuthor(p);
		}  
		
		//случайный выбор адресата
		public static void makeOutgoingAddressee(Outgoing outgoing){
			Person p =NameStorage.loadedPeople.list.get(new Random().nextInt(NameStorage.loadedPeople.list.size()));
			outgoing.setAuthor(p);
		}
	    
		//случайный выбор способа доставки
		public static void makeDelivery(Outgoing outgoing){    	
			outgoing.setDelivery(NameStorage.delivery[new Random().nextInt(3)]);
		}
		
		//определение типа документа    
		public static String typeToString(Document document){
			String str = null;		
			if (document.getType()==DocType.TASK) str = "Поручение";
			if (document.getType()==DocType.INCOMING) str = "Входящий";
			if (document.getType()==DocType.OUTGOING) str = "Исходящий";
			return str;		
		}  
		
		//генерация даты выдачи/
		public static void makeDeliveryDate(Task task){
			task.setDeliveryDate(FactoryUtil.RandomDate());
		}
			    
		//генерация срока исполнения задания/
		public static void makeDueDate(Task task){
			task.setDueDate(task.getDeliveryDate());//срок исполнения не может быть раньше даты выдачи    	
		}
			    
		//случайный выбор исполнителя получения
		public static void makeExecutor(Task task){    	
			task.setExecutor(NameStorage.executor[new Random().nextInt(5)]);;
		}
			    
		//случайный выбор контролера
		public static void makeController(Task task){    	
			task.setController(NameStorage.controller[new Random().nextInt(5)]);
		}
			    
		//генерация признака контрольности
		public static void makeControleAttribute(Task task){
			task.setControleAttribute(NameStorage.controleAttribute[new Random().nextInt(3)]);
		}  
}
