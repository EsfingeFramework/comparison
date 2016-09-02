package net.sf.esfinge.comparison.processor;

import net.sf.esfinge.comparison.difference.Difference;

public interface ComparisonProcessor {
	
	public Difference compare(String prop, Object oldValue, Object newValue);

}
