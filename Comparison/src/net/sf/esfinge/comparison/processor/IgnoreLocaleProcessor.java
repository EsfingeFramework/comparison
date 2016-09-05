package net.sf.esfinge.comparison.processor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.difference.PropertyDifference;

public class IgnoreLocaleProcessor implements ComparisonProcessor {
	
	SimpleDateFormat dateFormated = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

	public Difference compare(String prop, Object oldValue, Object newValue) {
		String newDate = timezoneConversor(dateFormated.format(newValue));
		String oldDate = timezoneConversor(dateFormated.format(oldValue));
		if (newDate == null) {
			if (oldDate != null) {
				return new PropertyDifference(prop, newDate, oldDate);
			}
		} else if (!newDate.equals(oldDate)) {
			return new PropertyDifference(prop, newDate, oldDate);
		}
		return null;
	}
	
	private String timezoneConversor(String date) {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(dateFormated.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dateFormated.setTimeZone(TimeZone.getTimeZone("UTC"));
		dateFormated.applyPattern("HH:mm:ss");
		return dateFormated.format(calendar.getTime());
	}

}
