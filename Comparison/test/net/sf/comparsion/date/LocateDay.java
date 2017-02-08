package net.sf.comparsion.date;

import java.util.Calendar;

import net.sf.esfinge.comparison.annotation.DayTolerance;
import net.sf.esfinge.comparison.annotation.IgnoreHour;
import net.sf.esfinge.comparison.annotation.IgnoreLocale;

public class LocateDay {
	
	public Calendar cal;


	@IgnoreLocale
	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public LocateDay(Calendar cal) {

		this.cal = cal;
	}
	
	

}
