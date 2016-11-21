package net.sf.esfinge.comparison.layer;

import java.util.List;

import net.sf.esfinge.comparison.CompareException;
import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.difference.PropertyDifference;


public class NullComparisonLayer extends ComparisonLayer {
	@Override
	public boolean compare(Object oldValue, Object newValue,
			List<Difference> difs, PropertyDescriptor descProp)
			throws CompareException {
		
		if ((oldValue == null && newValue != null)
				|| (oldValue != null && newValue == null)) {
			Difference dif = new PropertyDifference(descProp.getName(), oldValue,newValue);
			System.out.println("Difference");
			System.out.println(dif);
			difs.add(dif);
			return true;
		}
		if(oldValue == null && newValue == null){
			return true;
		}
		return false;
	}
}
