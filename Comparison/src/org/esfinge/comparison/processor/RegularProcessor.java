package org.esfinge.comparison.processor;

import org.esfinge.comparison.difference.Difference;
import org.esfinge.comparison.difference.PropertyDifference;

public class RegularProcessor implements ComparisonProcessor {
	@Override
	public Difference compare(String prop, Object oldValue, Object newValue) {
		if (newValue == null) {
			if (oldValue != null) {
				return new PropertyDifference(prop, newValue, oldValue);
			}
		} else if (!newValue.equals(oldValue)) {
			return new PropertyDifference(prop, newValue, oldValue);
		}
		return null;
	}
}
