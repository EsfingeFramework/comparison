package net.sf.esfinge.comparison;

import net.sf.esfinge.comparison.processor.ComparisonProcessor;
import net.sf.esfinge.comparison.processor.RegularProcessor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ReflectionReference;

public class PropertyDescriptor {
	
	@ElementName
	private String name;
	
	private ComparisonProcessor processor;
	
	private boolean deepComparison;
	
	private boolean collectionComparison;
	@ReflectionReference
	private Class associateType;
	
	public ComparisonProcessor getProcessor() {
		if(processor == null)
			processor = new RegularProcessor();
		return processor;
	}
	public void setProcessor(ComparisonProcessor processor) {
		this.processor = processor;
	}
	
	//other getters and setters omitted
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDeepComparison() {
		return deepComparison;
	}
	public void setDeepComparison(boolean deep) {
		this.deepComparison = deep;
	}
	public boolean isCollectionComparison() {
		return collectionComparison;
	}
	public void setCollectionComparison(boolean listComparison) {
		this.collectionComparison = listComparison;
	}
	public Class getAssociateType() {
		return associateType;
	}
	public void setAssociateType(Class type) {
		this.associateType = type;
	}

}
