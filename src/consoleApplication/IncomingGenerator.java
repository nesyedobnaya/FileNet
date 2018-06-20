package consoleApplication;

import java.util.Random;

public class IncomingGenerator extends Generator{
	
	//генерация входящего документа
	public static Document createIncoming() {
		Incoming incoming = new Incoming();		
		makeOutgoingRegistrationDate(incoming);    	
		makeOutgoingNumber(incoming);    	
		makeSender(incoming);    	
		makeAddressee(incoming);    	
		return incoming;    
	}
    
	//генерация исходящей даты регистрации
	public static void makeOutgoingRegistrationDate(Incoming incoming){
		incoming.outgoingRegistrationDate=RandomDate();
	}
    
	//генерация исходящего регистрационного номера
	public static void makeOutgoingNumber(Incoming incoming){
		incoming.outgoingNumber=(int)(Math.random()*10000);
	}
    
	//случайный выбор отправителя
	public static void makeSender(Incoming incoming){
		incoming.sender=NameStorage.sender[new Random().nextInt(5)];
	}
    
	//случайный выбор адресата
	public static void makeAddressee(Incoming incoming){
		incoming.addressee=NameStorage.addressee[new Random().nextInt(5)];
	}  
    
}
