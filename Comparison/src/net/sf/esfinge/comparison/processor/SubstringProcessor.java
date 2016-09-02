package net.sf.esfinge.comparison.processor;

import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.difference.PropertyDifference;

public class SubstringProcessor implements ComparisonProcessor {
	
	private int begin;
	private int end;
	
	public SubstringProcessor(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
	@Override
	public Difference compare(String prop, Object oldValue, Object newValue) {
		if (newValue == null) {
			if (oldValue != null) {
				return new PropertyDifference(prop, newValue, oldValue);
			}
		} else{
			String oldString, newString;
			if(end == Integer.MAX_VALUE){
				oldString = oldValue.toString().substring(begin);
				newString = newValue.toString().substring(begin);
			}else{
				oldString = oldValue.toString().substring(begin, end);
				newString = newValue.toString().substring(begin, end);
			}
			if(!oldString.equals(newString))
				return new PropertyDifference(prop, newValue, oldValue);
		}
		return null;
	}
}
