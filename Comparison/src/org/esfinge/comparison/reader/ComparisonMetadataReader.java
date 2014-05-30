package org.esfinge.comparison.reader;

import org.esfinge.comparison.ComparisonDescriptor;

public interface ComparisonMetadataReader {

	public abstract void populateContainer(Class c, ComparisonDescriptor descriptor);

}