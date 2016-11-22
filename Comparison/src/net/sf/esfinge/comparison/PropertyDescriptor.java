package net.sf.esfinge.comparison;

import java.util.List;

import net.sf.esfinge.comparison.annotation.CollectionComparison;
import net.sf.esfinge.comparison.annotation.DeepComparison;
import net.sf.esfinge.comparison.metadata.Associate;
import net.sf.esfinge.comparison.processor.ComparisonProcessor;
import net.sf.esfinge.comparison.processor.RegularProcessor;
import net.sf.esfinge.comparison.reader.delegate.DelegateReader;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.Processors;
import net.sf.esfinge.metadata.annotation.container.PropertyContainsAnnotation;
import net.sf.esfinge.metadata.annotation.container.PropertyProcessors;
import net.sf.esfinge.metadata.annotation.container.ReflectionReference;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.ALL)
public class PropertyDescriptor {
	
	@ElementName
	private String name;
	
	@PropertyProcessors(DelegateReader.class)
	private List<ComparisonProcessor> processorNew;
	
	
	private ComparisonProcessor processor;
	
	private boolean deepComparison;

	private boolean collectionComparison;
	
	@Associate({CollectionComparison.class,DeepComparison.class})
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
		System.err.println(collectionComparison);
		return collectionComparison;
	}
	public void setCollectionComparison(boolean listComparison) {
		this.collectionComparison = listComparison;
	}
	public Class getAssociateType() {
		System.err.println(associateType);
		return associateType;
	}
	public void setAssociateType(Class type) {
		this.associateType = type;
	}
	public List<ComparisonProcessor> getProcessorNew() {
		return processorNew;
	}
	public void setProcessorNew(List<ComparisonProcessor> processorNew) {
		this.processorNew = processorNew;
	}
	
	

}
