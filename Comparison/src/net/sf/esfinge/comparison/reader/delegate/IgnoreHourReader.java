package net.sf.esfinge.comparison.reader.delegate;

import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.comparison.annotation.IgnoreHour;
import net.sf.esfinge.comparison.processor.IgnoreHourProcessor;

public class IgnoreHourReader implements AnnotationReader<IgnoreHour> {
	
	public void readAnnotation(IgnoreHour annotation, PropertyDescriptor descriptor) {
		IgnoreHourProcessor p = new IgnoreHourProcessor();
		descriptor.setProcessor(p);
	}


}
