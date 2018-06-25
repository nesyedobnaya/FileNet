package ru.grusha.model;

import java.util.Date;

public class Incoming extends Document{
	 
	private Person sender;//отправитель 
	private Person addressee;//адресат    
	private int outgoingNumber;//исходящий номер 
	private Date outgoingRegistrationDate;//исходящая дата регистрации	
	
	public Person getSender() {
		return sender;
	}

	public void setSender(Person person) {
		this.sender = person;
	}

	public Person getAddressee() {
		return addressee;
	}

	public void setAddressee(Person person) {
		this.addressee = person;
	}

	public int getOutgoingNumber() {
		return outgoingNumber;
	}

	public void setOutgoingNumber(int outgoingNumber) {
		this.outgoingNumber = outgoingNumber;
	}

	public Date getOutgoingRegistrationDate() {
		return outgoingRegistrationDate;
	}

	public void setOutgoingRegistrationDate(Date outgoingRegistrationDate) {
		this.outgoingRegistrationDate = outgoingRegistrationDate;
	}
    
	@Override
	public String toString() {
		return "Входящий документ №" + getRegistrationNumber()
			+", ID: " + getID() 
			+", Название документа: " + getName() 			
			+", Дата регистрации: " + getRegistrationDate() 			
			+", Автор: " + getAuthor() 			
			+", Текст документа: "+getText()			
			+", Отправитель: "+ getSender()			
			+", Адресат: " + getAddressee()			
			+", Исходящий номер: "+ getOutgoingNumber()			
			+", Исходящая дата регистрации: " + getOutgoingRegistrationDate();    
	}
}
