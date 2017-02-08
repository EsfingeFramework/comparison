package net.sf.esfinge.comparison.processor;

import java.text.DateFormat;
import java.util.Calendar;

import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.difference.PropertyDifference;

public class IgnoreDayProcessor implements ComparisonProcessor  {
	
	public Difference compare(String prop, Object oldValue, Object newValue) {
		String newDate = removeDay((Calendar) newValue);
		String oldDate = removeDay((Calendar) oldValue);
		if (newDate == null) {
			if (oldDate != null) {
				return new PropertyDifference(prop, newDate, oldDate);
			}
		} else if (!newDate.equals(oldDate)) {
			return new PropertyDifference(prop, newDate, oldDate);
		}
		return null;
	}

	private String removeDay(Calendar date) {
		return DateFormat.getTimeInstance().format(date.getTime());
	}

}
