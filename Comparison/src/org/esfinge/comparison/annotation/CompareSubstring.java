package org.esfinge.comparison.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.comparison.reader.delegate.DelegateReader;
import org.esfinge.comparison.reader.delegate.SubstringComparisonReader;


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@DelegateReader(SubstringComparisonReader.class)
public @interface CompareSubstring {
	int begin() default 0;
	int end() default Integer.MAX_VALUE;
}
