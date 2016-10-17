package net.sf.esfinge.comparison;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.layer.CollectionItensComparisonLayer;
import net.sf.esfinge.comparison.layer.ComparisonLayer;
import net.sf.esfinge.comparison.layer.DeepComparisonLayer;
import net.sf.esfinge.comparison.layer.NullComparisonLayer;
import net.sf.esfinge.comparison.layer.ValueComparisonLayer;
import net.sf.esfinge.comparison.utils.BeanUtils;


public class ComparisonComponentNew {
	
	private List<ComparisonLayer> layers;
	
	private Set<Object> compared = new HashSet<Object>();
		
	public ComparisonComponentNew(ComparisonLayer... layers){
		
	}
	
	public ComparisonComponentNew(){
		
	}

	public List<Difference> compare(Object oldObj, Object newObj)
			throws CompareException {

		addCompared(oldObj, newObj);
		
		List<Difference> difs = new ArrayList<Difference>();

		return difs;
	}

	private void compareProperties(Object oldObj, Object newObj,
			List<Difference> difs, ComparisonDescriptor descr)
			throws CompareException {
		
	}

	private void compareUsingLayers(List<Difference> difs, Object oldValue,
			Object newValue, PropertyDescriptor descProp)
			throws CompareException {

	}
	
	public void addCompared(Object oldObj, Object newObj){
		compared.add(oldObj);
		compared.add(newObj);
	}
	
	public void removeCompared(Object oldObj, Object newObj){
		compared.remove(oldObj);
		compared.remove(newObj);
	}
	
	
	public boolean hasObjects(Object oldObj, Object newObj){
		return compared.contains(oldObj) && compared.contains(newObj);
	}
	
}
