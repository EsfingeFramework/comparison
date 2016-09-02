package net.sf.esfinge.comparison.processor;

import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.difference.PropertyDifference;

public class ToleranceProcessor implements ComparisonProcessor {

	private double tolerance;
	
	public ToleranceProcessor(double tolerance) {
		this.tolerance = tolerance;
	}
	@Override
	public Difference compare(String prop, Object oldValue, Object newValue) {
		double dif = Math.abs(((Double) newValue) - ((Double) oldValue));
		if (dif > tolerance) {
			return new PropertyDifference(prop, newValue, oldValue);
		}
		return null;
	}
}
