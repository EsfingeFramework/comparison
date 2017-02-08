package net.sf.esfinge.comparison.processor;

import java.text.DateFormat;
import java.util.Calendar;

import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.difference.PropertyDifference;

public class IgnoreHourProcessor implements ComparisonProcessor {

	public Difference compare(String prop, Object oldValue, Object newValue) {
		String newDate = removeHour((Calendar) newValue);
		String oldDate = removeHour((Calendar) oldValue);

		if (newDate == null) {
			if (oldDate != null) {
				return new PropertyDifference(prop, newValue, oldValue);
			}
		} else if (!newDate.equals(oldDate)) {
			return new PropertyDifference(prop, newValue, oldValue);
		}
		return null;
	}

	private String removeHour(Calendar date) {
		return DateFormat.getDateInstance(DateFormat.LONG).format(date.getTime());
		
	}

}
