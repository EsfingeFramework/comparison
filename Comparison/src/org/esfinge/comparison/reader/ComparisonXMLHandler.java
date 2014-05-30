package org.esfinge.comparison.reader;

import org.esfinge.comparison.ComparisonDescriptor;
import org.esfinge.comparison.PropertyDescriptor;
import org.esfinge.comparison.processor.ToleranceProcessor;

import net.sf.jColtrane.annotations.args.Attribute;
import net.sf.jColtrane.annotations.methods.StartDocument;
import net.sf.jColtrane.annotations.methods.StartElement;

public class ComparisonXMLHandler {
	
	private ComparisonDescriptor descriptor;
	
	@StartElement(tag="prop")
	public void addProperty(
			@Attribute("name") String name,
			@Attribute("tolerance") Float tolerance,
			@Attribute("deep") Boolean deep){
		PropertyDescriptor pd = descriptor.getPropertyDescriptor(name);
		if(pd == null){
			pd = new PropertyDescriptor();
			pd.setName(name);
			descriptor.addPropertyDescriptor(pd);
		}
		if(tolerance != null)
			pd.setProcessor(new ToleranceProcessor(tolerance));
		if(deep != null)
			pd.setDeepComparison(deep);
	}

	public ComparisonDescriptor getDescriptor() {
		return descriptor;
	}
	public void setDescriptor(ComparisonDescriptor d){
		descriptor = d;
	}
}
