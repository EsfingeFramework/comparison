package net.sf.conventions.dayTolerance;

import java.util.Calendar;

public class WithoutAnnotationAndConention {
    Calendar cal;

    public WithoutAnnotationAndConention (Calendar cal){
        this.cal=cal;
    }

    public Calendar getCal() {
        return cal;
    }

    public void setCal(Calendar cal) {
        this.cal = cal;
    }
}
