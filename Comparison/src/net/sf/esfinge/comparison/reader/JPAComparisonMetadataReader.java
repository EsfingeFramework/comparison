package net.sf.esfinge.comparison.reader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Transient;

import net.sf.esfinge.comparison.ComparisonDescriptor;
import net.sf.esfinge.comparison.utils.BeanUtils;
import net.sf.esfinge.metadata.AnnotationReader;


public class JPAComparisonMetadataReader implements
		ComparisonMetadataReader {


	@Override
	public void populateContainer(Class c, ComparisonDescriptor descriptor) {
		
				
		descriptor.setIdProp(BeanUtils.getIdProp(c));
		//for(String prop : descriptor.getSetProperties()){
		//	try {
		//		Method m = c.getMethod(BeanUtils.propertyToGetter(prop));
		//		Class returnType = m.getReturnType();
		//		if(returnType.isAnnotationPresent(Entity.class)){
		//			descriptor.getPropertyDescriptor(prop).setDeepComparison(true);
		//		}else if(Collection.class.isAssignableFrom(returnType)){
		//			configureCollectionComparison(descriptor, prop, m);
		//		}
		//		System.out.println("");
		//		if(BeanUtils.isAnnotationPresentInProperty(prop, c, Transient.class)){
		//			descriptor.removePropertyDescriptor(prop);
		//		}
		//		
		//	} catch (Exception e) {
		//		throw new RuntimeException("Problemas ao recuperar o metodo", e);
		//	}
		//}
		//System.out.println();
	}
}