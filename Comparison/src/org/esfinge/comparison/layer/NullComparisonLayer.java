package org.esfinge.comparison.layer;

import java.util.List;

import org.esfinge.comparison.CompareException;
import org.esfinge.comparison.PropertyDescriptor;
import org.esfinge.comparison.difference.Difference;
import org.esfinge.comparison.difference.PropertyDifference;


public class NullComparisonLayer extends ComparisonLayer {
	@Override
	public boolean compare(Object oldValue, Object newValue,
			List<Difference> difs, PropertyDescriptor descProp)
			throws CompareException {
		if ((oldValue == null && newValue != null)
				|| (oldValue != null && newValue == null)) {
			Difference dif = new PropertyDifference(descProp.getName(), oldValue,newValue);
			difs.add(dif);
			return true;
		}
		if(oldValue == null && newValue == null){
			return true;
		}
		return false;
	}
}
