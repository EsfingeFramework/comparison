package net.sf.conventions.tolerance;

public class WithoutToleranceMetadata {


    private Double value;

    public WithoutToleranceMetadata(double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
