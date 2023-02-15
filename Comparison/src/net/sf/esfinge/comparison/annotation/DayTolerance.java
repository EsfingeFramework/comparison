package net.sf.esfinge.comparison.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.comparison.reader.delegate.DelegateReader;
import net.sf.esfinge.comparison.reader.delegate.DayToleranceReader;
import net.sf.esfinge.metadata.locate.conventions.annotations.SuffixConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.FixedIntegerValue;


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@DelegateReader(DayToleranceReader.class)
@SuffixConvention(value = "Tolerance")
public @interface DayTolerance {
	@FixedIntegerValue(1)
	int value();
}
