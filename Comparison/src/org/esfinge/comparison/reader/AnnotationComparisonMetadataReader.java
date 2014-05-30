package org.esfinge.comparison.reader;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.esfinge.comparison.ComparisonDescriptor;
import org.esfinge.comparison.PropertyDescriptor;
import org.esfinge.comparison.annotation.IgnoreInComparison;
import org.esfinge.comparison.reader.delegate.AnnotationReader;
import org.esfinge.comparison.reader.delegate.DelegateReader;
import org.esfinge.comparison.utils.BeanUtils;


public class AnnotationComparisonMetadataReader implements ComparisonMetadataReader {

	public void populateContainer(Class c, ComparisonDescriptor descr){
		for (Method method : c.getMethods()) {
			boolean isGetter = method.getName().startsWith("get");
			boolean noParameters = (method.getParameterTypes().length == 0);
			boolean notGetClass = !method.getName().equals("getClass");
			boolean noIgnore = !method.isAnnotationPresent(IgnoreInComparison.class);
			if (isGetter && noParameters && notGetClass && noIgnore) {
				String propName = BeanUtils.acessorToProperty(method.getName());
				PropertyDescriptor prop = getPropertyDescriptor(descr, method,
						propName);
				for(Annotation an :method.getAnnotations()){
					readAnnotation(prop, an);
				}
			}
		}
	}

	private PropertyDescriptor getPropertyDescriptor(
			ComparisonDescriptor descr, Method method, String propName) {
		PropertyDescriptor prop = descr.getPropertyDescriptor(propName);
		if(prop == null){
			prop = new PropertyDescriptor();
			prop.setName(propName);
			prop.setAssociateType(method.getReturnType());
			descr.addPropertyDescriptor(prop);
		}
		return prop;
	}

	private void readAnnotation(PropertyDescriptor prop, Annotation an) {
		Class anType = an.annotationType();
		if(anType.isAnnotationPresent(DelegateReader.class)){
			DelegateReader reader = (DelegateReader) anType.getAnnotation(DelegateReader.class);
			Class<? extends AnnotationReader> readerClass = reader.value();
			try {
				AnnotationReader anReader = readerClass.newInstance();
				anReader.readAnnotation(an, prop);
			} catch (Exception e) {
				throw new RuntimeException("Can not instanciate reader",e);
			}
		}
	}
}
