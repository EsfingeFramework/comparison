package net.sf.esfinge.comparison.integration;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.esfinge.comparison.ComparisonComponent;
import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.difference.ListChanceDifference;
import net.sf.esfinge.comparison.difference.ListChange;
import net.sf.esfinge.comparison.difference.PropertyDifference;
import net.sf.esfinge.comparison.reader.AnnotationComparisonMetadataReader;
import net.sf.esfinge.comparison.reader.ChainComparisonMetatataReader;
import net.sf.esfinge.comparison.reader.JPAComparisonMetadataReader;
import net.sf.esfinge.comparison.reader.MetadataReaderProvider;

public class ListComparisonTestOld {
	

	@BeforeClass
	public static void setReaderProvider(){
		ChainComparisonMetatataReader chainReader = 
			new ChainComparisonMetatataReader(
					new AnnotationComparisonMetadataReader(),
					new JPAComparisonMetadataReader()
			);
		MetadataReaderProvider.set(chainReader);
	}
	
	@Test
	public void differencesInStringList() throws Exception{
		Bean b1 = new Bean();
		b1.setList(Arrays.asList("Eduardo", "Andriano", "Henrique"));
		Bean b2 = new Bean();
		b2.setList(Arrays.asList("Eduardo", "Henrique", "Joao"));
		
		ComparisonComponent cc = new ComparisonComponent();
		List<Difference> l = cc.compare(b1, b2);
		
		assertEquals(2, l.size());
		assertEquals("list", l.get(0).getPath());
		assertEquals(ListChange.ADDED, ((ListChanceDifference)l.get(0)).getChangeType());
		assertEquals("Joao", ((ListChanceDifference)l.get(0)).getItem());
		assertEquals("list", l.get(1).getPath());
		assertEquals(ListChange.REMOVED, ((ListChanceDifference)l.get(1)).getChangeType());
		assertEquals("Andriano", ((ListChanceDifference)l.get(1)).getItem());
	}
	
	@Test
	public void differencesInCompositeList() throws Exception{
		IntBean old_ib1 = new IntBean(1,13,"ABC");
		IntBean old_ib2 = new IntBean(2,23,"BCD");
		IntBean old_ib3 = new IntBean(3,33,"CDE");
		
		IntBean new_ib1 = new IntBean(1,13,"ABC");
		IntBean new_ib2 = new IntBean(4,43,"ZZZ");
		IntBean new_ib3 = new IntBean(3,33,"CDE");
		
		Bean b1 = new Bean();
		b1.setCompList(Arrays.asList(old_ib1, old_ib2, old_ib3));
		Bean b2 = new Bean();
		b2.setCompList(Arrays.asList(new_ib1, new_ib2, new_ib3));
		
		ComparisonComponent cc = new ComparisonComponent();
		List<Difference> l = cc.compare(b1, b2);
		
		assertEquals(2, l.size());
		assertEquals("compList[id=4]", l.get(0).getPath());
		assertEquals(ListChange.ADDED, ((ListChanceDifference)l.get(0)).getChangeType());
		assertEquals(new_ib2, ((ListChanceDifference)l.get(0)).getItem());
		assertEquals("compList[id=2]", l.get(1).getPath());
		assertEquals(ListChange.REMOVED, ((ListChanceDifference)l.get(1)).getChangeType());
		assertEquals(old_ib2, ((ListChanceDifference)l.get(1)).getItem());
	}
	
	@Test
	public void differencesInCompositeListWithNullID() throws Exception{
		IntBean old_ib1 = new IntBean(1,13,"ABC");
		IntBean old_ib2 = new IntBean(2,23,"BCD");
		
		IntBean new_ib1 = new IntBean(1,13,"ABC");
		IntBean new_ib2 = new IntBean(2,23,"BCD");
		IntBean new_ib3 = new IntBean(null,33,"CDE");
		
		Bean b1 = new Bean();
		b1.setCompList(Arrays.asList(old_ib1, old_ib2));
		Bean b2 = new Bean();
		b2.setCompList(Arrays.asList(new_ib1, new_ib2, new_ib3));
		
		ComparisonComponent cc = new ComparisonComponent();
		List<Difference> l = cc.compare(b1, b2);
		
		assertEquals(1, l.size());
		assertEquals("compList", l.get(0).getPath());
		assertEquals(ListChange.ADDED, ((ListChanceDifference)l.get(0)).getChangeType());
		assertEquals(new_ib3, ((ListChanceDifference)l.get(0)).getItem());

	}
	
	@Test
	public void differencesInListItensProp() throws Exception{
		IntBean old_ib1 = new IntBean(1,13,"ABC");
		IntBean old_ib2 = new IntBean(2,23,"BCD");
		IntBean old_ib3 = new IntBean(3,33,"CDE");
		
		IntBean new_ib1 = new IntBean(1,13,"ABC");
		IntBean new_ib2 = new IntBean(2,55,"BCD");
		IntBean new_ib3 = new IntBean(3,33,"EDC");
		
		Bean b1 = new Bean();
		b1.setCompList(Arrays.asList(old_ib1, old_ib2, old_ib3));
		Bean b2 = new Bean();
		b2.setCompList(Arrays.asList(new_ib1, new_ib2, new_ib3));
		
		ComparisonComponent cc = new ComparisonComponent();
		List<Difference> l = cc.compare(b1, b2);
		
		assertEquals(2, l.size());
		assertEquals("compList[id=2].prop1", l.get(0).getPath());
		assertEquals(55, ((PropertyDifference)l.get(0)).getNewValue());
		assertEquals(23, ((PropertyDifference)l.get(0)).getOldValue());
		assertEquals("compList[id=3].prop2", l.get(1).getPath());
		assertEquals("EDC", ((PropertyDifference)l.get(1)).getNewValue());
		assertEquals("CDE", ((PropertyDifference)l.get(1)).getOldValue());
	}

}
