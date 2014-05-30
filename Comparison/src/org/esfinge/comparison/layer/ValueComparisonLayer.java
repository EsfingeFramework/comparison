package org.esfinge.comparison.layer;

import java.lang.reflect.Method;
import java.util.List;

import org.esfinge.comparison.CompareException;
import org.esfinge.comparison.PropertyDescriptor;
import org.esfinge.comparison.difference.Difference;
import org.esfinge.comparison.processor.ComparisonProcessor;


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
