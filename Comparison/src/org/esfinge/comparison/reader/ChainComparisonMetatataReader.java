package org.esfinge.comparison.reader;

import java.util.ArrayList;
import java.util.List;

import org.esfinge.comparison.ComparisonDescriptor;


public class ChainComparisonMetatataReader implements ComparisonMetadataReader {

	private List<ComparisonMetadataReader> readers;

	public ChainComparisonMetatataReader(ComparisonMetadataReader... readers) {
		this.readers = new ArrayList<ComparisonMetadataReader>();
		for(ComparisonMetadataReader reader : readers){
			this.readers.add(reader);
		}
	}
	@Override
	public void populateContainer(Class c, ComparisonDescriptor descriptor) {
		for(ComparisonMetadataReader reader : readers){
			reader.populateContainer(c, descriptor);
		}
	}
}
