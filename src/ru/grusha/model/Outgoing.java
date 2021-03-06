package ru.grusha.model;

import ru.grusha.utils.FormatUtil;

public class Outgoing extends Document {
	
    private String addressee;//адресат
     
    private String delivery;//способ доставки
    
    public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
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
    		+ ", Автор: " + getAuthor() 
    		+ ", Текст документа: " + getText()
    		+ ", Адресат: "+ getAddressee()
    		+ ", Способ доставки: "+ getDelivery();       
	}

	@Override
	public void setTableName() {}
}
