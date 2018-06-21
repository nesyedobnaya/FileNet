package fileWork;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "organization")
public class Organization {
	
	protected String fullName;//полное название
	protected String shortName;//краткое название
	protected String chief;//руководитель
	protected String telephone;//контактные телефоны
	
	@XmlElement
	public void setFullName(String name) {
		this.fullName = name;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	@XmlElement
	public void setShortName(String name) {
		this.shortName = name;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	@XmlElement
	public void setChief(String name) {
		this.chief = name;
	}
	
	public String getChief() {
		return chief;
	}
	
	@XmlElement
	public void setTelephone(String name) {
		this.telephone = name;
	}
	
	public String getTelephone() {
		return telephone;
	}
}
