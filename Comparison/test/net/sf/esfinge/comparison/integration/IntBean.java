package net.sf.esfinge.comparison.integration;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IntBean{
	@Id private Integer id;
	private int prop1;
	private String prop2;
	public IntBean(Integer id, int prop1, String prop2) {
		this.id = id;
		this.prop1 = prop1;
		this.prop2 = prop2;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getProp1() {
		return prop1;
	}
	public void setProp1(int prop1) {
		this.prop1 = prop1;
	}
	public String getProp2() {
		return prop2;
	}
	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}
}
