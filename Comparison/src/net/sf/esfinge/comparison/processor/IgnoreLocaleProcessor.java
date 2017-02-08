package net.sf.esfinge.comparison.processor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.difference.PropertyDifference;

public class IgnoreLocaleProcessor implements ComparisonProcessor {
	
	SimpleDateFormat dateFormated = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

	public Difference compare(String prop, Object oldValue, Object newValue) {
		Calendar oldD = (GregorianCalendar) oldValue;
		Calendar newD = (GregorianCalendar) newValue;

		String newDate = timezoneConversor(newD);
		String oldDate = timezoneConversor(oldD);

		
		if (newDate == null) {
			if (oldDate != null) {
				return new PropertyDifference(prop, newDate, oldDate);
			}
		} else if (!newDate.equals(oldDate)) {
			return new PropertyDifference(prop, newDate, oldDate);
		}
		return null;
	}
	
	private String timezoneConversor(Calendar calendar) {	
	
		String data = calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
		return data;
	}

}
