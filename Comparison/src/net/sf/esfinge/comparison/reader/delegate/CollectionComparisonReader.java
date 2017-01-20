package net.sf.esfinge.comparison.reader.delegate;

import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.comparison.annotation.CollectionComparison;
import net.sf.esfinge.comparison.annotation.DeepComparison;

public class CollectionComparisonReader implements AnnotationReader<CollectionComparison> {

	@Override
	public void readAnnotation(CollectionComparison annotation, 
			PropertyDescriptor descriptor){
		descriptor.setCollectionComparison(true);
	}

}
