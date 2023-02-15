package net.sf.conventions.dayTolerance;

import net.sf.esfinge.comparison.ComparisonComponent;
import net.sf.esfinge.comparison.difference.Difference;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DayToleranceConventionTest {
    @Test
    public void toleranceWithConventionEmpty() throws Exception {
        Calendar date1,date2;
        WithDayToleranceConvention c1,c2;
        date1 = Calendar.getInstance();
        date1.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));

        date2 = Calendar.getInstance();

        date2.setTimeZone(TimeZone.getTimeZone("GMT"));
        date1.set(2023, 01, 15, 15,12,00);
        date2.set(2023, 01, 14, 16,12,01);
        c1= new WithDayToleranceConvention(date1);
        c2 = new WithDayToleranceConvention(date2);

        ComparisonComponent c = new ComparisonComponent();
        List<Difference> difs = c.compare(c1, c2);
        assertTrue(difs.isEmpty());

    }
    @Test
    public void toleranceWithConventionHasDifferences() throws Exception {
        Calendar date1,date2;
        WithDayToleranceConvention c1,c2;
        date1 = Calendar.getInstance();
        date1.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));

        date2 = Calendar.getInstance();

        date2.setTimeZone(TimeZone.getTimeZone("GMT"));
        date1.set(2023, 01, 15, 15,12,00);
        date2.set(2023, 01, 13, 15,12,00);
        c1= new WithDayToleranceConvention(date1);
        c2 = new WithDayToleranceConvention(date2);
        ComparisonComponent c = new ComparisonComponent();
        List<Difference> difs = c.compare(c1, c2);
        assertFalse(difs.isEmpty());

    }

    @Test
    public void toleranceWithoutConventionAndAnnotationDifferences() throws Exception {
        Calendar date1,date2;
        WithoutAnnotationAndConention c1,c2;
        date1 = Calendar.getInstance();
        date1.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));

        date2 = Calendar.getInstance();

        date2.setTimeZone(TimeZone.getTimeZone("GMT"));
        date1.set(2023, 01, 15, 15,12,00);
        date2.set(2023, 01, 13, 15,12,00);
        c1= new WithoutAnnotationAndConention(date1);
        c2 = new WithoutAnnotationAndConention(date2);
        ComparisonComponent c = new ComparisonComponent();
        List<Difference> difs = c.compare(c1, c2);
        assertFalse(difs.isEmpty());

    }
}
