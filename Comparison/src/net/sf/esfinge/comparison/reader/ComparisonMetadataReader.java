package net.sf.esfinge.comparison.reader;

import net.sf.esfinge.comparison.ComparisonDescriptor;

public interface ComparisonMetadataReader {

	public abstract void populateContainer(Class c, ComparisonDescriptor descriptor);

}