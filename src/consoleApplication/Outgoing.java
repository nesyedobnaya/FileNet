package consoleApplication;

public class Outgoing extends Document {
	
    String addressee;//адресат
     
    String delivery;//способ доставки
    
    @Override
	public String toString() {
    	return "Исходящий документ №"+registrationNumber
    		+ ", ID: " + ID 
    		+ ", Название: " + name 
    		+ ", Дата регистрации: " + registrationDate 
    		+ ", Автор: " + author 
    		+ ", Текст документа: " + text
    		+ ", Адресат: " + addressee
    		+ ", Способ доставки: " + delivery;       
	}
}
