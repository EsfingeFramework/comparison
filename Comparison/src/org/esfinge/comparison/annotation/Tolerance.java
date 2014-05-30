package org.esfinge.comparison.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.comparison.reader.delegate.DelegateReader;
import org.esfinge.comparison.reader.delegate.ToleranceReader;


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@DelegateReader(ToleranceReader.class)
public @interface Tolerance {
	double value();
}
