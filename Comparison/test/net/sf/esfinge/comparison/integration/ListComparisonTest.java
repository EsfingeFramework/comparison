package net.sf.esfinge.comparison.integration;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.esfinge.comparison.CompareException;
import net.sf.esfinge.comparison.ComparisonComponent;
import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.difference.ListChanceDifference;
import net.sf.esfinge.comparison.difference.ListChange;
import net.sf.esfinge.comparison.difference.PropertyDifference;
import net.sf.esfinge.comparison.reader.AnnotationComparisonMetadataReader;
import net.sf.esfinge.comparison.reader.ChainComparisonMetatataReader;
import net.sf.esfinge.comparison.reader.JPAComparisonMetadataReader;
import net.sf.esfinge.comparison.reader.MetadataReaderProvider;

public class ListComparisonTest {
	
	@Entity
	public class IntBean{
		@Id private Integer id;
		private int prop1;
		private String prop2;
		public IntBean(Integer id, int prop1, String prop2) {
			super();
			this.id = id;
			this.prop1 = prop1;
			this.prop2 = prop2;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public int getProp1() {
			return prop1;
		}
		public void setProp1(int prop1) {
			this.prop1 = prop1;
		}
		public String getProp2() {
			return prop2;
		}
		public void setProp2(String prop2) {
			this.prop2 = prop2;
		}
	}
	
	public class Bean{
		private List<String> list;
		private List<IntBean> compList;
		public List<String> getList() {
			return list;
		}
		public void setList(List<String> list) {
			this.list = list;
		}
		public List<IntBean> getCompList() {
			return compList;
		}
		public void setCompList(List<IntBean> compList) {
			this.compList = compList;
		}
	}
	
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
	public void differencesInStringList() throws CompareException{
		Bean b1 = new Bean();
		b1.setList(Arrays.asList("Eduardo", "Andr�", "Henrique"));
		Bean b2 = new Bean();
		b2.setList(Arrays.asList("Eduardo", "Henrique", "Jo�o"));
		
		ComparisonComponent cc = new ComparisonComponent();
		List<Difference> l = cc.compare(b1, b2);
		
		assertEquals(2, l.size());
		assertEquals("list", l.get(0).getPath());
		assertEquals(ListChange.ADDED, ((ListChanceDifference)l.get(0)).getChangeType());
		assertEquals("Jo�o", ((ListChanceDifference)l.get(0)).getItem());
		assertEquals("list", l.get(1).getPath());
		assertEquals(ListChange.REMOVED, ((ListChanceDifference)l.get(1)).getChangeType());
		assertEquals("Andr�", ((ListChanceDifference)l.get(1)).getItem());
	}
	
	@Test
	public void differencesInCompositeList() throws CompareException{
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
	public void differencesInCompositeListWithNullID() throws CompareException{
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
	public void differencesInListItensProp() throws CompareException{
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
