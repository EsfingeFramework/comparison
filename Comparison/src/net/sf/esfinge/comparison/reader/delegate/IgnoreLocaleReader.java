package net.sf.esfinge.comparison.reader.delegate;

import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.comparison.annotation.IgnoreLocale;
import net.sf.esfinge.comparison.processor.IgnoreLocaleProcessor;

public class IgnoreLocaleReader implements AnnotationReader<IgnoreLocale> {
	
	public void readAnnotation(IgnoreLocale annotation, PropertyDescriptor descriptor) {
		IgnoreLocaleProcessor p = new IgnoreLocaleProcessor();
		descriptor.setProcessor(p);
	}

}
