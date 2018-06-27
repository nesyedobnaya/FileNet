package ru.grusha.model;

import java.util.Date;

public class Task extends Document {
	
	private Date deliveryDate;//дата выдачи поручения
	private Date dueDate;//срок исполнения поручения   
	private String executor;//ответственный исполнитель   
	private boolean controleAttribute;//признак контрольности        
	private String controller;//контролер поручения
    
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public boolean getControleAttribute() {
		return controleAttribute;
	}

	public void setControleAttribute(boolean b) {
		this.controleAttribute = b;
	}

	@Override
	public String toString() {
		return "Поручение № " + getRegistrationNumber()
			+ ", ID:  " + getID() 
			+ ", Название документа: " + getName() 
			+ " Дата регистрации: " + getRegistrationDate() 
			+ ", Автор: " + getAuthor() 
			+ ", Текст документа: "+ getText() 
			+ ", Дата выдачи: " + getDeliveryDate()
			+ ", Срок исполнения: " + getDueDate()
			+ ", Ответственный исполнитель: " + getExecutor()				
			+ ", Исполнено: " + getControleAttribute()
			+ ", Контролер: " + getController();
	}	
}
