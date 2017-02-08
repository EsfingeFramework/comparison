package net.sf.esfinge.comparison;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;

import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.layer.CollectionItensComparisonLayer;
import net.sf.esfinge.comparison.layer.ComparisonLayer;
import net.sf.esfinge.comparison.layer.DeepComparisonLayer;
import net.sf.esfinge.comparison.layer.NullComparisonLayer;
import net.sf.esfinge.comparison.layer.ValueComparisonLayer;
import net.sf.esfinge.comparison.utils.BeanUtils;
import net.sf.esfinge.metadata.AnnotationReader;


public class ComparisonComponent {
	
	private List<ComparisonLayer> layers;
	
	private Set<Object> compared = new HashSet<Object>();
		
	public ComparisonComponent(ComparisonLayer... layers){
		this.layers = new ArrayList<ComparisonLayer>();
		for(ComparisonLayer layer : layers){
			layer.setComponent(this);
			this.layers.add(layer);
		}
	}
	
	public ComparisonComponent(){
		this(new NullComparisonLayer(),
			 new DeepComparisonLayer(),
			 new CollectionItensComparisonLayer(),
			 new ValueComparisonLayer());
	}

	public List<Difference> compare(Object oldObj, Object newObj)
			throws Exception {

		addCompared(oldObj, newObj);
		
		List<Difference> difs = new ArrayList<Difference>();

		if (!newObj.getClass().isAssignableFrom(oldObj.getClass()))
			throw new CompareException("Not compatible types");
		
		
		
		AnnotationReader leitura = new AnnotationReader();
		
		ComparisonDescriptor descr = leitura.readingAnnotationsTo(oldObj.getClass(),ComparisonDescriptor.class);
				
		compareProperties(oldObj, newObj, difs, descr);
		
		removeCompared(oldObj, newObj);
		return difs;
	}

	private void compareProperties(Object oldObj, Object newObj,
			List<Difference> difs, ComparisonDescriptor descr)
			throws CompareException {
		for (String prop : descr.getSetProperties()) {
			try {
				Object oldValue = PropertyUtils.getSimpleProperty(oldObj, prop);
				Object newValue = PropertyUtils.getSimpleProperty(newObj, prop);
				
				//Modifico Aqui
				PropertyDescriptor descriptor = descr.getPropertyDescriptor(prop);
				
				compareUsingLayers(difs, oldValue, newValue, descriptor);
			} catch (Exception e) {
				throw new CompareException("Error retrieving property", e);
				//e.printStackTrace();
			}
		}
	}

	private void compareUsingLayers(List<Difference> difs, Object oldValue,
			Object newValue, PropertyDescriptor descProp)
			throws Exception {
		boolean compared = false;
		for(int i=0; i<layers.size() && !compared; i++){
			ComparisonLayer layer = layers.get(i);
			compared = layer.compare(oldValue, newValue, difs, descProp);
			
		}
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
