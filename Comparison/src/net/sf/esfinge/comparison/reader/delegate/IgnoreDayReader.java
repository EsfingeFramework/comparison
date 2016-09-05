package net.sf.esfinge.comparison.reader.delegate;

import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.comparison.annotation.IgnoreDay;
import net.sf.esfinge.comparison.processor.IgnoreDayProcessor;

public class IgnoreDayReader implements AnnotationReader<IgnoreDay> {
	
	public void readAnnotation(IgnoreDay annotation, PropertyDescriptor descriptor) {
		IgnoreDayProcessor p = new IgnoreDayProcessor();
		descriptor.setProcessor(p);
	}

}
