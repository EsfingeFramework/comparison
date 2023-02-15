package net.sf.conventions.tolerance;

import net.sf.esfinge.comparison.ComparisonComponent;
import net.sf.esfinge.comparison.difference.Difference;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ToleranceConventionTest {

    @Test
    public void withToleranceConventionTrueTest() throws Exception {
        WithToleranceConvention c1,c2;
        c1 = new WithToleranceConvention(0.1);
        c2 = new WithToleranceConvention(0.11);
        ComparisonComponent c = new ComparisonComponent();
        List<Difference> difs = c.compare(c1, c2);
        assertTrue(difs.isEmpty());

    }

    @Test
    public void withToleranceConventionFalseTest() throws Exception {
        WithToleranceConvention c1,c2;
        c1 = new WithToleranceConvention(0.1);
        c2 = new WithToleranceConvention(0.12);
        ComparisonComponent c = new ComparisonComponent();
        List<Difference> difs = c.compare(c1, c2);
        assertFalse(difs.isEmpty());

    }


    @Test
    public void withToleranceWithAnnotationTrueTest() throws Exception {
        WithToleranceAnnotation c1,c2;
        c1 = new WithToleranceAnnotation(0.1);
        c2 = new WithToleranceAnnotation(0.25);
        ComparisonComponent c = new ComparisonComponent();
        List<Difference> difs = c.compare(c1, c2);
        assertTrue(difs.isEmpty());

    }

    @Test
    public void withToleranceWithAnnotationFalseTest() throws Exception {
        WithToleranceAnnotation c1,c2;
        c1 = new WithToleranceAnnotation(0.1);
        c2 = new WithToleranceAnnotation(0.35);
        ComparisonComponent c = new ComparisonComponent();
        List<Difference> difs = c.compare(c1, c2);
        assertFalse(difs.isEmpty());

    }


    @Test
    public void withToleranceWithoutMetadataTrueTest() throws Exception {
        WithoutToleranceMetadata c1,c2;
        c1 = new WithoutToleranceMetadata(0.11);
        c2 = new WithoutToleranceMetadata(0.11);
        ComparisonComponent c = new ComparisonComponent();
        List<Difference> difs = c.compare(c1, c2);
        assertTrue(difs.isEmpty());

    }

    @Test
    public void withToleranceWithoutMetadataFalseTest() throws Exception {
        WithoutToleranceMetadata c1,c2;
        c1 = new WithoutToleranceMetadata(0.12);
        c2 = new WithoutToleranceMetadata(0.11);
        ComparisonComponent c = new ComparisonComponent();
        List<Difference> difs = c.compare(c1, c2);
        assertFalse(difs.isEmpty());

    }
}
