package net.sf.esfinge.comparison.reader.delegate;

import java.lang.annotation.Annotation;

import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.metadata.annotation.container.ExecuteProcessor;


public interface AnnotationReader<A extends Annotation> {
	
	@ExecuteProcessor
	public void readAnnotation(A annotation,
			PropertyDescriptor descriptor);

}
