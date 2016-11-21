package net.sf.esfinge.comparison.reader;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Transient;

import net.sf.esfinge.comparison.ComparisonDescriptor;
import net.sf.esfinge.comparison.utils.BeanUtils;


public class JPAComparisonMetadataReader implements
		ComparisonMetadataReader {


	@Override
	public void populateContainer(Class c, ComparisonDescriptor descriptor) {
		descriptor.setIdProp(BeanUtils.getIdProp(c));
		for(String prop : descriptor.getSetProperties()){
			try {
				Method m = c.getMethod(BeanUtils.propertyToGetter(prop));
				Class returnType = m.getReturnType();
				if(returnType.isAnnotationPresent(Entity.class)){
					descriptor.getPropertyDescriptor(prop).setDeepComparison(true);
				}else if(Collection.class.isAssignableFrom(returnType)){
					configureCollectionComparison(descriptor, prop, m);
				}
				if(BeanUtils.isAnnotationPresentInProperty(prop, c, Transient.class)){
					descriptor.removePropertyDescriptor(prop);
				}
				
			} catch (Exception e) {
				throw new RuntimeException("Problemas ao recuperar o metodo", e);
			}
		}
	}

	private void configureCollectionComparison(ComparisonDescriptor descriptor,
			String prop, Method m) {
		descriptor.getPropertyDescriptor(prop).setCollectionComparison(true);
		Class genericParam = (Class)((ParameterizedType) m.getGenericReturnType()).getActualTypeArguments()[0];
		if(genericParam.isAnnotationPresent(Entity.class)){
			descriptor.getPropertyDescriptor(prop).setDeepComparison(true);
			descriptor.getPropertyDescriptor(prop).setAssociateType(genericParam);
		}
	}
}
