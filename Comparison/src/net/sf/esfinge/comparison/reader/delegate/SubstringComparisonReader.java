package net.sf.esfinge.comparison.reader.delegate;

import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.comparison.annotation.CompareSubstring;
import net.sf.esfinge.comparison.processor.SubstringProcessor;

public class SubstringComparisonReader implements AnnotationReader<CompareSubstring> {
	@Override
	public void readAnnotation(CompareSubstring annotation, PropertyDescriptor descriptor) {
		int begin = annotation.begin();
		int end = annotation.end();
		SubstringProcessor p = new SubstringProcessor(begin,end);
		descriptor.setProcessor(p);
	}
}
