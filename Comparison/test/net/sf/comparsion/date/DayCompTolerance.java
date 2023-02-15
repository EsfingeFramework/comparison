package net.sf.comparsion.date;

import java.util.Calendar;

import net.sf.esfinge.comparison.annotation.DayTolerance;
import net.sf.esfinge.comparison.annotation.IgnoreHour;
import net.sf.esfinge.comparison.annotation.Tolerance;

public class DayCompTolerance {
	
	public Calendar cal;


	@IgnoreHour
	@DayTolerance(5)
	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public DayCompTolerance(Calendar cal) {

		this.cal = cal;
	}
	
	

}
