package org.esfinge.comparison.reader.delegate;

import java.lang.annotation.Annotation;

import org.esfinge.comparison.PropertyDescriptor;
import org.esfinge.comparison.annotation.DeepComparison;


public class DeepComparisonReader implements AnnotationReader<DeepComparison> {

	@Override
	public void readAnnotation(DeepComparison annotation, 
			PropertyDescriptor descriptor){
		descriptor.setDeepComparison(true);
	}

}
