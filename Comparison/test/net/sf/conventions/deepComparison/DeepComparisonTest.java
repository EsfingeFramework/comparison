package net.sf.conventions.deepComparison;

import net.sf.esfinge.comparison.ComparisonComponent;
import net.sf.esfinge.comparison.difference.Difference;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeepComparisonTest {
    @Test
    public void  deepInComparisonConventionTrue() throws Exception {
        WithDeepComparisonConvention c1,c2;

        c1 = new WithDeepComparisonConvention(new Item(3,"book"));
        c2 = new WithDeepComparisonConvention(new Item(12,"fork"));
        ComparisonComponent c = new ComparisonComponent();
        List<Difference> difs = c.compare(c1, c2);
        assertEquals(difs.size(),2);

    }

    @Test
    public void  withoutDeepComparisonMetadata() throws Exception {
        WithoutDeepComparisonMetadata c1,c2;

        c1 = new WithoutDeepComparisonMetadata(new Item(3,"book"));
        c2 = new WithoutDeepComparisonMetadata(new Item(12,"fork"));
        ComparisonComponent c = new ComparisonComponent();
        List<Difference> difs = c.compare(c1, c2);
        assertEquals(difs.size(),1);

    }
}
