package net.sf.esfinge.comparison.processor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.difference.PropertyDifference;

public class DayToleranceProcessor implements ComparisonProcessor {

	private int tolerance;
	
	public DayToleranceProcessor(int tolerance) {
		this.tolerance = tolerance;
	}

	SimpleDateFormat dateFormated = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public Difference compare(String prop, Object oldValue, Object newValue) {
		
		
		Calendar oldD = (Calendar) oldValue;
		Calendar newD = (Calendar) newValue;
		
		Calendar newDate = calendarConversor(dateFormated.format(oldD.getTime()));
		Calendar oldDate = calendarConversor(dateFormated.format(newD.getTime()));
		if (!anoIgual(newDate,oldDate)){
			return new PropertyDifference(prop, dateFormated.format(oldD.getTime()), dateFormated.format(newD.getTime()));
		}
		if (getDif(newDate,oldDate) > tolerance) {
			return new PropertyDifference(prop, dateFormated.format(oldD.getTime()), dateFormated.format(newD.getTime()));
		}
		return null;
	}
	
	private int getDif(Calendar newDate, Calendar oldDate) {
		int dif = Math.abs(newDate.get(Calendar.DAY_OF_MONTH) - oldDate.get(Calendar.DAY_OF_MONTH));
		return dif;
	}

	private Calendar calendarConversor(String date){
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(dateFormated.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	}
	
	private boolean anoIgual(Calendar newDate, Calendar oldDate){
		if (newDate.get(Calendar.MONTH) == oldDate.get(Calendar.MONTH))
			if (newDate.get(Calendar.YEAR) == oldDate.get(Calendar.YEAR))
				return true;
		return false;
	}
}
