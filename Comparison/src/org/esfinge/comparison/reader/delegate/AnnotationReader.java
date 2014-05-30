package org.esfinge.comparison.reader.delegate;

import java.lang.annotation.Annotation;

import org.esfinge.comparison.PropertyDescriptor;


public interface AnnotationReader<A extends Annotation> {
	
	public void readAnnotation(A annotation,
			PropertyDescriptor descriptor);

}
