package org.esfinge.comparison.reader.delegate;

import org.esfinge.comparison.PropertyDescriptor;
import org.esfinge.comparison.annotation.Tolerance;
import org.esfinge.comparison.processor.ToleranceProcessor;

public class ToleranceReader implements AnnotationReader<Tolerance>{
	@Override
	public void readAnnotation(Tolerance annotation, 
			PropertyDescriptor descriptor){
		double tolerance = annotation.value();
		ToleranceProcessor processor = new ToleranceProcessor(tolerance);
		descriptor.setProcessor(processor);
	}
}
