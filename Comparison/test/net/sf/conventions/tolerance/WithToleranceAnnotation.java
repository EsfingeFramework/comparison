package net.sf.conventions.tolerance;

import net.sf.esfinge.comparison.annotation.Tolerance;

public class WithToleranceAnnotation {

    private double value;

    public WithToleranceAnnotation(double value) {
        this.value = value;
    }
    @Tolerance(0.2)
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
