package net.sf.esfinge.comparison.processor;

import java.text.DateFormat;

import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.difference.PropertyDifference;

public class IgnoreHourProcessor implements ComparisonProcessor {

	public Difference compare(String prop, Object oldValue, Object newValue) {
		String newDate = removeHour(newValue);
		String oldDate = removeHour(oldValue);
		if (newDate == null) {
			if (oldDate != null) {
				return new PropertyDifference(prop, newValue, oldValue);
			}
		} else if (!newDate.equals(oldDate)) {
			return new PropertyDifference(prop, newValue, oldValue);
		}
		return null;
	}

	private String removeHour(Object date) {
		return DateFormat.getDateInstance(DateFormat.LONG).format(date);
	}

}
