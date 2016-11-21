package net.sf.esfinge.comparison;

import java.util.HashMap;
import java.util.Map;

import net.sf.esfinge.comparison.reader.ComparisonMetadataReader;
import net.sf.esfinge.comparison.reader.MetadataReaderProvider;


public class Repository {
	
	private static Repository instance;
	
	public static Repository getInstance(){
		if(instance == null){
			instance = new Repository();
		}
		return instance;
	}
	
	private Map<Class, ComparisonDescriptor> cache;
	
	private Repository(){
		cache = new HashMap<Class, ComparisonDescriptor>();
	}
	public ComparisonDescriptor getMetadata(Class clazz){
		if(cache.containsKey(clazz)){
			return cache.get(clazz); 
		}
		ComparisonMetadataReader reader = MetadataReaderProvider.get();
		ComparisonDescriptor cd = new ComparisonDescriptor();
		reader.populateContainer(clazz,cd);
		cache.put(clazz, cd);
		return cd;
	}
}
