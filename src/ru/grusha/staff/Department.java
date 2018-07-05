package ru.grusha.staff;

public class Department extends Staff{
	
	private String fullName;//полное название
	private String shortName;//краткое название
	private String chief;//руководитель
	private String telephone;//контактные телефоны

	public void setFullName(String name) {
		this.fullName = name;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setShortName(String name) {
		this.shortName = name;
	}
	
	public String getShortName() {
		return shortName;
	}

	public void setChief(String name) {
		this.chief = name;
	}
	
	public String getChief() {
		return chief;
	}

	public void setTelephone(String name) {
		this.telephone = name;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public String toString() {
		String str = "Полное название: "+getFullName()
				+", Краткое название: "+getShortName()
				+", Руководитель: "+getChief()
				+", Телефон: "+getTelephone()+" ";	        
		return str;		  	
	}
}