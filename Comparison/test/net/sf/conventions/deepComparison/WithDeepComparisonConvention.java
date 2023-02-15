package net.sf.conventions.deepComparison;

import net.sf.esfinge.comparison.annotation.CollectionComparison;
import net.sf.esfinge.comparison.annotation.DeepComparison;
import net.sf.esfinge.comparison.integration.IntBean;

import java.util.List;

public class WithDeepComparisonConvention {

    private Item itemDeep;

    public WithDeepComparisonConvention(Item itemDeep) {
        this.itemDeep = itemDeep;
    }

    public Item getItemDeep() {
        return itemDeep;
    }
    public void setItemDeep(Item itemDeep) {
        this.itemDeep = itemDeep;
    }

}
