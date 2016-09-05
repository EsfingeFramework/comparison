package net.sf.esfinge.comparison.reader.delegate;

import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.comparison.annotation.DayTolerance;
import net.sf.esfinge.comparison.processor.DayToleranceProcessor;

public class DayToleranceReader implements AnnotationReader<DayTolerance>{

	public void readAnnotation(DayTolerance annotation, 
			PropertyDescriptor descriptor){
		int tolerance = annotation.value();
		DayToleranceProcessor processor = new DayToleranceProcessor(tolerance);
		descriptor.setProcessor(processor);
	}
}
