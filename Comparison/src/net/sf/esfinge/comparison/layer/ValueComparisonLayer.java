package net.sf.esfinge.comparison.layer;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.esfinge.comparison.CompareException;
import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.processor.ComparisonProcessor;


public class ValueComparisonLayer extends ComparisonLayer {
	@Override
	public boolean compare(Object oldValue, Object newValue,
			List<Difference> difs, PropertyDescriptor descProp)
			throws CompareException {
		ComparisonProcessor processor = descProp.getProcessor();
		Difference dif = processor.compare(descProp.getName(), oldValue, newValue);
		if(dif != null)
			difs.add(dif);
		return true;
	}
}
