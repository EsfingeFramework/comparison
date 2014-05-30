package org.esfinge.comparison;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ComparisonDescriptor {
	
	private Map<String,PropertyDescriptor> properties =
		new HashMap<String, PropertyDescriptor>();
	
	private String idProp;
	
	public void addPropertyDescriptor(PropertyDescriptor descProp){
		properties.put(descProp.getName(), descProp);
	}
	public void removePropertyDescriptor(String prop){
		properties.remove(prop);
	}
	public PropertyDescriptor getPropertyDescriptor(String prop){
		return properties.get(prop);
	}
	public Set<String> getProperties(){
		return properties.keySet();
	}
	public String getIdProp() {
		return idProp;
	}
	public void setIdProp(String idProp) {
		this.idProp = idProp;
	}

}
