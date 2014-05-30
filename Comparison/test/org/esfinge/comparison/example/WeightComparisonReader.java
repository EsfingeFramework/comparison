package org.esfinge.comparison.example;

import org.esfinge.comparison.PropertyDescriptor;
import org.esfinge.comparison.processor.ToleranceProcessor;
import org.esfinge.comparison.reader.delegate.AnnotationReader;


public class WeightComparisonReader implements AnnotationReader<Weight> {

	@Override
	public void readAnnotation(Weight annotation, 
			PropertyDescriptor descriptor) {
		ToleranceProcessor processor = new ToleranceProcessor(0.1);
		descriptor.setProcessor(processor);
	}

}
