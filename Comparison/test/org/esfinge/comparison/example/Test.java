package org.esfinge.comparison.example;

import java.util.List;

import org.esfinge.comparison.CompareException;
import org.esfinge.comparison.ComparisonComponent;
import org.esfinge.comparison.difference.Difference;


public class Test {

	public static void main(String[] args) throws CompareException {
		//ComparisonMetadataReader r = new ChainComparisonMetatataReader(
		//		new AnnotationComparisonMetadataReader(),
		//		new XMLComparisonMetadataReader()
		//	);
		//MetadataReaderProvider.set(r);
		Person p1 = new Person("Sr. Z�",70.5f,20);
		Address e1 = new Address("Pariquis","50");
		p1.setAddress(e1);
		Person p2 = new Person("Dr. Z�",70.7f,21);
		Address e2 = new Address("Pariquis","55");
		p2.setAddress(e2);
		ComparisonComponent c = new ComparisonComponent();
		List<Difference> difs = c.compare(p2, p1);
		
		for(Difference d : difs){
			System.out.println(d);
		}

	}

}
