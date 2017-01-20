package net.sf.esfinge.comparison.example;

import static org.junit.Assert.*;

import java.util.List;

import org.jmock.lib.AssertionErrorTranslator;
import org.junit.Test;

import net.sf.esfinge.comparison.CompareException;
import net.sf.esfinge.comparison.ComparisonComponent;
import net.sf.esfinge.comparison.difference.Difference;


public class Teste {

	@Test
	public void test() throws Exception {
		Person p1 = new Person("Sr. Ze",70.5f,20);
		Address e1 = new Address("Pariquis","50");
		p1.setAddress(e1);
		Person p2 = new Person("Dr. Ze",70.7f,21);
		Address e2 = new Address("Pariquis","51");
		p2.setAddress(e2);
		ComparisonComponent c = new ComparisonComponent();
		List<Difference> difs = c.compare(p2, p1);
		assertEquals(difs.get(0).toString(),"address.number : 51 / 50");
		assertEquals(difs.get(1).toString(),"weight : 70.69999694824219 / 70.5");

	}

}
