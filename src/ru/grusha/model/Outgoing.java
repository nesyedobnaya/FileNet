package ru.grusha.model;

import ru.grusha.staff.Person;

public class Outgoing extends Document {
	
    private Person addressee;//адресат     
    private String delivery;//способ доставки
    
    public Person getAddressee() {
		return addressee;
	}

	public void setAddressee(Person person) {
		this.addressee = person;
	}
	
	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
    
	@Override
	public String toString() {
    	return "Исходящий документ №" + getRegistrationNumber()
    		+ ", ID: " + getID() 
    		+ ", Название документа: " + getName() 
    		+ ", Дата регистрации: " + getRegistrationDate() 
    		+ ", Автор: " + getAuthor() 
    		+ ", Текст документа: " + getText()
    		+ ", Адресат: "+ getAddressee()
    		+ ", Способ доставки: "+ getDelivery();       
	}
}
