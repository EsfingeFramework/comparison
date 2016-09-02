package net.sf.esfinge.comparison.reader.delegate;

import java.lang.annotation.Annotation;

import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.comparison.annotation.DeepComparison;


public class DeepComparisonReader implements AnnotationReader<DeepComparison> {

	@Override
	public void readAnnotation(DeepComparison annotation, 
			PropertyDescriptor descriptor){
		descriptor.setDeepComparison(true);
	}

}
