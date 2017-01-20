package net.sf.esfinge.comparison.integration;

import static net.sf.esfinge.classmock.ClassMockUtils.set;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.Entity;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.Location;
import net.sf.esfinge.comparison.ComparisonComponent;
import net.sf.esfinge.comparison.annotation.DeepComparison;
import net.sf.esfinge.comparison.annotation.IgnoreInComparison;
import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.difference.PropertyDifference;
import net.sf.esfinge.comparison.reader.ChainComparisonMetatataReader;
import net.sf.esfinge.comparison.reader.JPAComparisonMetadataReader;
import net.sf.esfinge.comparison.reader.MetadataReaderProvider;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ComparisonTest {
	
	private ClassMock mockBean;
	private ClassMock mockInternalBean;
	private Class intClazz;
	private Class clazz;
	
	@Before
	public void createClasses(){
		mockInternalBean = new ClassMock("Internal");
		mockInternalBean.addProperty("intProp1", String.class);
		mockInternalBean.addProperty("intProp2", int.class);

		mockBean = new ClassMock("Bean");
		mockBean.addProperty("prop1", String.class);
		mockBean.addProperty("prop2", int.class);
	}
	
	@BeforeClass
	public static void setReaderProvider(){
		ChainComparisonMetatataReader chainReader = 
			new ChainComparisonMetatataReader(
					new JPAComparisonMetadataReader()
			);
		MetadataReaderProvider.set(chainReader);
	}
	
	@Test
	public void regularComparison() throws Exception{
		clazz = mockBean.createClass();
		
		Object beanA = clazz.newInstance();
		set(beanA, "prop1", "value");
		set(beanA, "prop2", 13);
		
		Object beanB = clazz.newInstance();
		set(beanB, "prop1", "value");
		set(beanB, "prop2", 23);
		
		ComparisonComponent cc = new ComparisonComponent();
		List<Difference> l = cc.compare(beanA, beanB);
		
		assertEquals(1, l.size());
		assertEquals("prop2", l.get(0).getPath());
		assertEquals(23, ((PropertyDifference)l.get(0)).getNewValue());
		assertEquals(13, ((PropertyDifference)l.get(0)).getOldValue());
	}
	
	@Test
	public void comparisonWithIgnore() throws Exception{
		mockBean.addAnnotation("prop2", IgnoreInComparison.class,Location.GETTER);
		clazz = mockBean.createClass();
		
		Object beanA = clazz.newInstance();
		set(beanA, "prop1", "value");
		set(beanA, "prop2", 13);
		
		Object beanB = clazz.newInstance();
		set(beanB, "prop1", "value");
		set(beanB, "prop2", 23);
		
		ComparisonComponent cc = new ComparisonComponent();
		List<Difference> l = cc.compare(beanA, beanB);
		
		assertEquals(0, l.size());
	}
	
	@Test
	public void comparisonWithOtherObject() throws Exception{
		intClazz = mockInternalBean.createClass();
		mockBean.addProperty("prop3", intClazz);
		clazz = mockBean.createClass();
		
		Object beanA = clazz.newInstance();
		set(beanA, "prop1", "value");
		set(beanA, "prop2", 13);

		Object internalBeanA = intClazz.newInstance();
		set(internalBeanA, "intProp1", "intervalue");
		set(internalBeanA, "intProp2", 111);
		
		set(beanA, "prop3", internalBeanA);
		
		Object beanB = clazz.newInstance();
		set(beanB, "prop1", "value");
		set(beanB, "prop2", 13);
		
		Object internalBeanB = intClazz.newInstance();
		set(internalBeanB, "intProp1", "intervalue");
		set(internalBeanB, "intProp2", 111);
		
		set(beanB, "prop3", internalBeanB);
		
		ComparisonComponent cc = new ComparisonComponent();
		List<Difference> l = cc.compare(beanA, beanB);
		
		assertEquals(1, l.size());
		assertEquals("prop3", l.get(0).getPath());
		assertEquals(internalBeanB, ((PropertyDifference)l.get(0)).getNewValue());
		assertEquals(internalBeanA, ((PropertyDifference)l.get(0)).getOldValue());
	}

	@Test
	public void compositeComparison() throws Exception{
		intClazz = mockInternalBean.createClass();
		mockBean.addProperty("prop3", intClazz);
		mockBean.addAnnotation("prop3", DeepComparison.class,Location.GETTER);
		clazz = mockBean.createClass();
		
		Object beanA = clazz.newInstance();
		set(beanA, "prop1", "value");
		set(beanA, "prop2", 13);

		Object internalBeanA = intClazz.newInstance();
		set(internalBeanA, "intProp1", "intervalue");
		set(internalBeanA, "intProp2", 111);
		
		set(beanA, "prop3", internalBeanA);
		
		Object beanB = clazz.newInstance();
		set(beanB, "prop1", "value");
		set(beanB, "prop2", 13);
		
		Object internalBeanB = intClazz.newInstance();
		set(internalBeanB, "intProp1", "newvalue");
		set(internalBeanB, "intProp2", 111);
		
		set(beanB, "prop3", internalBeanB);
		
		ComparisonComponent cc = new ComparisonComponent();
		List<Difference> l = cc.compare(beanA, beanB);
		
		assertEquals(1, l.size());
		assertEquals("prop3.intProp1", l.get(0).getPath());
		assertEquals("newvalue", ((PropertyDifference)l.get(0)).getNewValue());
		assertEquals("intervalue", ((PropertyDifference)l.get(0)).getOldValue());
	}
	
	@Test
	public void recursiveComparison() throws Exception{
		mockInternalBean.addProperty("intProp3", Object.class);
		mockInternalBean.addAnnotation("intProp3", DeepComparison.class,Location.GETTER);
		intClazz = mockInternalBean.createClass();
		mockBean.addProperty("prop3", intClazz);
		mockBean.addAnnotation("prop3", DeepComparison.class,Location.GETTER);
		clazz = mockBean.createClass();
		
		Object beanA = clazz.newInstance();
		set(beanA, "prop1", "value");
		set(beanA, "prop2", 13);

		Object internalBeanA = intClazz.newInstance();
		set(internalBeanA, "intProp1", "intervalue");
		set(internalBeanA, "intProp2", 111);
		set(internalBeanA, "intProp3", beanA);
		
		set(beanA, "prop3", internalBeanA);
		
		Object beanB = clazz.newInstance();
		set(beanB, "prop1", "newvalue");
		set(beanB, "prop2", 13);
		
		Object internalBeanB = intClazz.newInstance();
		set(internalBeanB, "intProp1", "intervalue");
		set(internalBeanB, "intProp2", 333);
		set(internalBeanB, "intProp3", beanB);
		
		set(beanB, "prop3", internalBeanB);
		
		ComparisonComponent cc = new ComparisonComponent();
		List<Difference> l = cc.compare(beanA, beanB);
		
		assertEquals(2, l.size());
		assertEquals("prop1", l.get(0).getPath());
		assertEquals("newvalue", ((PropertyDifference)l.get(0)).getNewValue());
		assertEquals("value", ((PropertyDifference)l.get(0)).getOldValue());
		assertEquals("prop3.intProp2", l.get(1).getPath());
		assertEquals(333, ((PropertyDifference)l.get(1)).getNewValue());
		assertEquals(111, ((PropertyDifference)l.get(1)).getOldValue());
	}
	
	@Test
	public void comparisonBasedOnJPA() throws Exception{
		mockInternalBean.addAnnotation(Entity.class);
		intClazz = mockInternalBean.createClass();
		mockBean.addProperty("prop3", intClazz);
		mockBean.addAnnotation("prop3", DeepComparison.class,Location.GETTER);
		clazz = mockBean.createClass();
		
		Object beanA = clazz.newInstance();
		set(beanA, "prop1", "value");
		set(beanA, "prop2", 13);

		Object internalBeanA = intClazz.newInstance();
		set(internalBeanA, "intProp1", "intervalue");
		set(internalBeanA, "intProp2", 111);
		
		set(beanA, "prop3", internalBeanA);
		
		Object beanB = clazz.newInstance();
		set(beanB, "prop1", "value");
		set(beanB, "prop2", 13);
		
		Object internalBeanB = intClazz.newInstance();
		set(internalBeanB, "intProp1", "newvalue");
		set(internalBeanB, "intProp2", 111);
		
		set(beanB, "prop3", internalBeanB);
		
		ComparisonComponent cc = new ComparisonComponent();
		List<Difference> l = cc.compare(beanA, beanB);
		
		
		assertEquals(1, l.size());
		assertEquals("prop3.intProp1", l.get(0).getPath());
		assertEquals("newvalue", ((PropertyDifference)l.get(0)).getNewValue());
		assertEquals("intervalue", ((PropertyDifference)l.get(0)).getOldValue());
	}
	
}
