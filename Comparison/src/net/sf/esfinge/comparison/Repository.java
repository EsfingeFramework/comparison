package net.sf.esfinge.comparison;

import java.util.HashMap;
import java.util.Map;

import net.sf.esfinge.comparison.reader.ComparisonMetadataReader;
import net.sf.esfinge.comparison.reader.MetadataReaderProvider;
import net.sf.esfinge.metadata.AnnotationReader;


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
	public ComparisonDescriptor getMetadata(Class clazz) throws Exception{
		if(cache.containsKey(clazz)){
			return cache.get(clazz); 
		}
		AnnotationReader reader = new AnnotationReader();
		ComparisonDescriptor cd = new ComparisonDescriptor();
		cd = reader.readingAnnotationsTo(clazz, cd.getClass());
		cache.put(clazz, cd);
		return cd;
	}
}
