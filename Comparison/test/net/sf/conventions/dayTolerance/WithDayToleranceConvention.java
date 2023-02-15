package net.sf.conventions.dayTolerance;

import net.sf.esfinge.comparison.annotation.IgnoreHour;

import java.util.Calendar;

public class WithDayToleranceConvention {
    Calendar calTolerance;


    public WithDayToleranceConvention(Calendar cal){
        this.calTolerance=cal;
    }
    @IgnoreHour
    public Calendar getCalTolerance() {
        return calTolerance;
    }

    public void setCalTolerance(Calendar calTolerance) {
        this.calTolerance = calTolerance;
    }
}
