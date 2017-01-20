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
	}
}