package net.sf.conventions.deepComparison;

import net.sf.esfinge.comparison.annotation.CollectionComparison;
import net.sf.esfinge.comparison.integration.IntBean;

import java.util.List;

public class WithoutDeepComparisonMetadata {

    private Item item;

    public WithoutDeepComparisonMetadata(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }

}
