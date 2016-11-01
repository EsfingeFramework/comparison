package net.sf.esfinge.comparison;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ProcessFields;
import net.sf.esfinge.metadata.annotation.container.ProcessMethods;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.TYPE)
public class ComparisonDescriptor {
	
	
	
	private Map<String,PropertyDescriptor> properties = new HashMap<String, PropertyDescriptor>();
	
	@ProcessMethods
	private Map<Method,PropertyDescriptor> propertiesNew;
	
	@ElementName
	private String idProp;
	
	/*public void addPropertyDescriptor(PropertyDescriptor descProp){
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
	}*/
	
	
	
	
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
	
	public Map<Method, PropertyDescriptor> getPropertiesNew() {
		return propertiesNew;
	}
	public void setPropertiesNew(Map<Method, PropertyDescriptor> propertiesNew) {
		this.propertiesNew = propertiesNew;
	}
	
	
	
}
