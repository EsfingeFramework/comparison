package net.sf.esfinge.comparison.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.comparison.reader.delegate.DelegateReader;
import net.sf.esfinge.comparison.reader.delegate.ToleranceReader;
import net.sf.esfinge.metadata.locate.conventions.annotations.MethodReturnTypeConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.FixedDoubleValue;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.FixedIntegerValue;


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@DelegateReader(ToleranceReader.class)
@MethodReturnTypeConvention(returnType = double.class,canBeSubtype = false)
public @interface Tolerance {
	@FixedDoubleValue(0.01)
	double value();
}
