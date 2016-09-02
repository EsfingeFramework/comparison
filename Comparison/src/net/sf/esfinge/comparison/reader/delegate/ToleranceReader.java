package net.sf.esfinge.comparison.reader.delegate;

import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.comparison.annotation.Tolerance;
import net.sf.esfinge.comparison.processor.ToleranceProcessor;

public class ToleranceReader implements AnnotationReader<Tolerance>{
	@Override
	public void readAnnotation(Tolerance annotation, 
			PropertyDescriptor descriptor){
		double tolerance = annotation.value();
		ToleranceProcessor processor = new ToleranceProcessor(tolerance);
		descriptor.setProcessor(processor);
	}
}
