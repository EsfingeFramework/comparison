package net.sf.conventions.tolerance;

public class WithToleranceConvention {

    private double value;

    public WithToleranceConvention(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
