package org.esfinge.comparison.layer;

import java.util.List;

import org.esfinge.comparison.CompareException;
import org.esfinge.comparison.ComparisonComponent;
import org.esfinge.comparison.PropertyDescriptor;
import org.esfinge.comparison.difference.Difference;


public abstract class ComparisonLayer {
	
	private ComparisonComponent component;
	
	public abstract boolean compare(Object oldValue, Object newValue, 
			List<Difference> difs, PropertyDescriptor descProp) throws CompareException ;
	
	public ComparisonComponent getComponent() {
		return component;
	}
	public void setComponent(ComparisonComponent component) {
		this.component = component;
	}
}
