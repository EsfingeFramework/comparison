package net.sf.esfinge.comparison.layer;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.sf.esfinge.comparison.CompareException;
import net.sf.esfinge.comparison.ComparisonComponent;
import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.comparison.difference.Difference;


public abstract class ComparisonLayer {
	
	private ComparisonComponent component;
	
	public abstract boolean compare(Object oldValue, Object newValue, 
			List<Difference> difs, PropertyDescriptor descProp) throws CompareException, IllegalAccessException, InvocationTargetException, NoSuchMethodException ;
	
	public ComparisonComponent getComponent() {
		return component;
	}
	public void setComponent(ComparisonComponent component) {
		this.component = component;
	}
}
