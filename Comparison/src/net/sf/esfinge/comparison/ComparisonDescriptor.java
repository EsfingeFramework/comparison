package net.sf.esfinge.comparison;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.sf.esfinge.comparison.annotation.IgnoreInComparison;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ElementPropertyWithoutAnnotation;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.TYPE)
public class ComparisonDescriptor {
	
	
	@ElementPropertyWithoutAnnotation(IgnoreInComparison.class)
	private Map<String,PropertyDescriptor> properties;
	//private Map<String,PropertyDescriptor> properties = new HashMap<String, PropertyDescriptor>();
	
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
	public Set<String> getSetProperties(){
		return properties.keySet();
	}
	public String getIdProp() {
		return idProp;
	}
	public void setIdProp(String idProp) {
		this.idProp = idProp;
	}
	///OLDDDDDDDDDDDDDDDDDDDDDDDDDDDDD
	

	public void setProperties(Map<String, PropertyDescriptor> propertiesNew) {
		this.properties = propertiesNew;
	}
	@Override
	public String toString() {
		return "ComparisonDescriptor [properties=" + properties + ", idProp=" + idProp + "]";
	}
	
	
	
	
}
