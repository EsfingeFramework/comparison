package net.sf.esfinge.comparison.layer;

import java.util.List;

import net.sf.esfinge.comparison.CompareException;
import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.comparison.difference.Difference;


public class DeepComparisonLayer extends ComparisonLayer {

	@Override
	public boolean compare(Object oldValue, Object newValue,
			List<Difference> difs, PropertyDescriptor descProp) throws CompareException {
		if (descProp.isDeepComparison() && !descProp.isCollectionComparison()) {
			if(!getComponent().hasObjects(oldValue, newValue)){
				deepComparison(oldValue, newValue, difs, descProp);
			}
			return true;
		}
		return false;
	}

	private void deepComparison(Object oldValue, Object newValue,
			List<Difference> difs, PropertyDescriptor descProp)
			throws CompareException {
		List<Difference> difsProp;
		try {
			difsProp = getComponent().compare(oldValue, newValue);
			for (Difference d : difsProp) {
				d.setPath(descProp.getName() + "." + d.getPath());
				difs.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
