package ru.grusha.staff;

public abstract class Staff {
	
	private int ID;//идентификатор
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public int getLID() {
		return this.ID;
	}
}