package net.sf.conventions.ignoreInComparison;

import net.sf.esfinge.comparison.ComparisonComponent;
import net.sf.esfinge.comparison.difference.Difference;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class IgnoreInComparisonTest {

    @Test
    public void withIgnoreInComparisonConventionNoDifference() throws Exception {
        IgnoreInComparisonWithConvention c1,c2;
        c1 = new IgnoreInComparisonWithConvention(25,"className");
        c2 = new IgnoreInComparisonWithConvention(28,"className");
        ComparisonComponent c = new ComparisonComponent();
        List<Difference> difs = c.compare(c1,c2);
        assertEquals(difs.size(),0);
    }

    @Test
    public void withIgnoreInComparisonConventionNameDifference() throws Exception {
        IgnoreInComparisonWithConvention c1,c2;
        c1 = new IgnoreInComparisonWithConvention(25,"className1");
        c2 = new IgnoreInComparisonWithConvention(28,"className2");
        ComparisonComponent c = new ComparisonComponent();
        List<Difference> difs = c.compare(c1,c2);
        assertEquals(difs.size(),1);
    }

    @Test
    public void withoutIgnoreInComparisonMetadataBothDifferent() throws Exception {
        WithoutMetadata c1,c2;
        c1 = new WithoutMetadata(25,"className1");
        c2 = new WithoutMetadata(28,"className2");
        ComparisonComponent c = new ComparisonComponent();
        List<Difference> difs = c.compare(c1,c2);
        assertEquals(difs.size(),2);
    }
}
