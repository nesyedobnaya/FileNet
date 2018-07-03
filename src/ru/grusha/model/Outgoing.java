package ru.grusha.model;

import javax.xml.bind.annotation.XmlRootElement;

import ru.grusha.staff.Person;
import ru.grusha.utils.FormatUtil;

@XmlRootElement(name = "outgoing")
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
    		+ ", Дата регистрации: " + FormatUtil.formatDate(getRegistrationDate()) 
    		+ ", Автор: " + getAuthor().getFullName() 
    		+ ", Текст документа: " + getText()
    		+ ", Адресат: "+ getAddressee().getFullName()
    		+ ", Способ доставки: "+ getDelivery();       
	}

	@Override
	public void setTableName() {}
}
