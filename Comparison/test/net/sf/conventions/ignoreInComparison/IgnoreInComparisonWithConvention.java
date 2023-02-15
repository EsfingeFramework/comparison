package net.sf.conventions.ignoreInComparison;

public class IgnoreInComparisonWithConvention {

    private int IgnoreAge;
    private String name;

    public IgnoreInComparisonWithConvention(int ignoreAge, String name) {
        IgnoreAge = ignoreAge;
        this.name = name;
    }

    public int getIgnoreAge() {
        return IgnoreAge;
    }

    public void setIgnoreAge(int ignoreAge) {
        IgnoreAge = ignoreAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
