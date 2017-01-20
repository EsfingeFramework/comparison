package net.sf.esfinge.comparison.example;

import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.comparison.processor.ToleranceProcessor;
import net.sf.esfinge.comparison.reader.delegate.AnnotationReader;


public class WeightComparisonReader implements AnnotationReader<Weight> {

	@Override
	public void readAnnotation(Weight annotation, 
			PropertyDescriptor descriptor) {
		System.out.println("==================EXECUTE=======================");
		ToleranceProcessor processor = new ToleranceProcessor(0.1);
		descriptor.setProcessor(processor);
	}

}
