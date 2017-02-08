package net.sf.comparsion.date;

import java.util.Calendar;

import net.sf.esfinge.comparison.annotation.DayTolerance;
import net.sf.esfinge.comparison.annotation.IgnoreDay;
import net.sf.esfinge.comparison.annotation.IgnoreHour;

public class DayCompIgnoreDay {
	
	public Calendar cal;


	@IgnoreHour
	@IgnoreDay
	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public DayCompIgnoreDay(Calendar cal) {

		this.cal = cal;
	}
	
	

}
