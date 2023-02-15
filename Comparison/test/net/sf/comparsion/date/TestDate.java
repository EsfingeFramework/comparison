package net.sf.comparsion.date;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.junit.Test;

import net.sf.esfinge.comparison.ComparisonComponent;
import net.sf.esfinge.comparison.difference.Difference;

public class TestDate {

	@Test
	public void dayToleranceTrue() throws Exception {
		Calendar date1,date2;
		DayCompTolerance compDate1, compDate2;
		
		
		date1 = Calendar.getInstance();
		date2 = Calendar.getInstance();
		
		date2.set(2023, 01, 14);

		compDate1 = new DayCompTolerance(date1);
		compDate2 = new DayCompTolerance(date2);
				
		ComparisonComponent c = new ComparisonComponent();
		List<Difference> difs = c.compare(compDate2, compDate1);
		
		assertTrue(difs.isEmpty());
		
	}
	
	
	@Test
	public void dayToleranceFalse() throws Exception {
		Calendar date1,date2;
		DayCompTolerance compDate1, compDate2;
		
		
		date1 = Calendar.getInstance();
		date2 = Calendar.getInstance();
		
		date2.set(2017, 01, 14);

		compDate1 = new DayCompTolerance(date1);
		compDate2 = new DayCompTolerance(date2);
		
		ComparisonComponent c = new ComparisonComponent();
		List<Difference> difs = c.compare(compDate2, compDate1);
		
		
		assertFalse(difs.isEmpty());
	}
	
	@Test
	public void dayToleranceIgnoreDayTrue() throws Exception {
		Calendar date1,date2;
		DayCompIgnoreDay compDate1, compDate2;
		
		
		date1 = Calendar.getInstance();
		date2 = Calendar.getInstance();
		
		date2.set(2017, 01, 14);

		compDate1 = new DayCompIgnoreDay(date1);
		compDate2 = new DayCompIgnoreDay(date2);
		
				
		ComparisonComponent c = new ComparisonComponent();
		List<Difference> difs = c.compare(compDate2, compDate1);
		assertTrue(difs.isEmpty());
	}
	
	@Test
	public void dayToleranceIgnoreDayFalse() throws Exception {
		Calendar date1,date2;
		DayCompIgnoreDay compDate1, compDate2;
		
		
		date1 = Calendar.getInstance();
		date2 = Calendar.getInstance();
		
		date2.set(2017, 00, 14);

		compDate1 = new DayCompIgnoreDay(date1);
		compDate2 = new DayCompIgnoreDay(date2);
		
				
		ComparisonComponent c = new ComparisonComponent();
		List<Difference> difs = c.compare(compDate2, compDate1);
		assertTrue(difs.isEmpty());
	}
	
	@Test
	public void locateTrue() throws Exception {
		Calendar date1,date2;
		LocateDay compDate1, compDate2;
		
		
		date1 = Calendar.getInstance();
		date1.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));
		
		
		date2 = Calendar.getInstance();
		date2.setTimeZone(TimeZone.getTimeZone("GMT+03:00"));
		
		
		date1.set(2017, 01, 14, 12,12,00);
		date2.set(2017, 01, 14, 12,12,00);

		compDate1 = new LocateDay(date1);
		compDate2 = new LocateDay(date2);
		
		
		compDate1 = new LocateDay(date1);
		compDate2 = new LocateDay(date2);

		
		ComparisonComponent c = new ComparisonComponent();
		List<Difference> difs = c.compare(compDate2, compDate1);
		assertTrue(difs.isEmpty());
		
	}
	
	@Test
	public void locateFalse() throws Exception {
		Calendar date1,date2;
		LocateDay compDate1a, compDate2a;
		
		
		date1 = Calendar.getInstance();
		date1.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));

		date2 = Calendar.getInstance();
		
		date2.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		date1.set(2017, 01, 14, 15,12,00);
		date2.set(2017, 01, 14, 12,12,00);

		compDate1a = new LocateDay(date1);
		compDate2a = new LocateDay(date2);
		
				
		ComparisonComponent c = new ComparisonComponent();
		List<Difference> difs = c.compare(compDate2a, compDate1a);
		assertFalse(difs.isEmpty());
	}



}
