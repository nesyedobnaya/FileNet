package consoleApplication;

import java.util.Date;

public class Incoming extends Document{
	 
	protected String sender;//отправитель 
	protected String addressee;//адресат    
	protected int outgoingNumber;//исходящий номер 
	protected Date outgoingRegistrationDate;//исходящая дата регистрации	
    
	@Override
	public String toString() {
		return "Входящий документ №"+registrationNumber
			+", ID: " + ID 
			+", Название документа: " + name 			
			+", Дата регистрации: " + registrationDate 			
			+", Автор: " + author 			
			+", Текст документа: "+text			
			+", Отправитель: "+sender			
			+", Адресат: "+addressee			
			+", Исходящий номер: "+outgoingNumber			
			+", Исходящая дата регистрации: " +outgoingRegistrationDate;    
	}
}
