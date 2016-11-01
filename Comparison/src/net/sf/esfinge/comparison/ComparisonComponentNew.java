package net.sf.esfinge.comparison;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.metadata.AnnotationReader;


public class ComparisonComponentNew {
	
	private Set<Object> compared = new HashSet<Object>();

	
	public ComparisonComponentNew(){
		
	}

	public List<Difference> compare(Object oldObj, Object newObj)
			throws Exception {

		AnnotationReader leitura = new AnnotationReader();
		
		Object objeto = leitura.readingAnnotationsTo(oldObj.getClass(),ComparisonDescriptor.class);
		
		addCompared(oldObj, newObj);
		
		List<Difference> difs = new ArrayList<Difference>();
		System.err.println(difs.size());

		return difs;
	}

	
	public void addCompared(Object oldObj, Object newObj){
		System.err.println("Não comparado");
	}
	
	public void removeCompared(Object oldObj, Object newObj){
	}
	
	
	public boolean hasObjects(Object oldObj, Object newObj){
		return compared.contains(oldObj) && compared.contains(newObj);
	}
	
}
