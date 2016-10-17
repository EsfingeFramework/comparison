package net.sf.esfinge.comparison.container;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.comparison.example.Address;
import net.sf.esfinge.comparison.example.Person;
import net.sf.esfinge.comparison.reader.AnnotationComparisonMetadataReader;
import net.sf.esfinge.comparison.reader.ChainComparisonMetatataReader;
import net.sf.esfinge.comparison.reader.JPAComparisonMetadataReader;
import net.sf.esfinge.comparison.reader.MetadataReaderProvider;
import net.sf.esfinge.metadata.AnnotationReader;

public class AnnotationContainerTest {



	
	@Test
	public void test() throws Exception {
		AnnotationReader reader = new AnnotationReader();
		Person p1 = new Person("Sr. Z",70.5f,20);
		Address e1 = new Address("Pariquis","50");
		ContainerComparsion comparsion = reader.readingAnnotationsTo(p1.getClass(), ContainerComparsion.class);
		System.err.println(comparsion.getProcessorMethods().toString());
	}

}
