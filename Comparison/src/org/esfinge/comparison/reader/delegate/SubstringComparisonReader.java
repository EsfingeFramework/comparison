package org.esfinge.comparison.reader.delegate;

import org.esfinge.comparison.PropertyDescriptor;
import org.esfinge.comparison.annotation.CompareSubstring;
import org.esfinge.comparison.processor.SubstringProcessor;

public class SubstringComparisonReader implements AnnotationReader<CompareSubstring> {
	@Override
	public void readAnnotation(CompareSubstring annotation, PropertyDescriptor descriptor) {
		int begin = annotation.begin();
		int end = annotation.end();
		SubstringProcessor p = new SubstringProcessor(begin,end);
		descriptor.setProcessor(p);
	}
}
