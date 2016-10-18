package net.sf.esfinge.comparison.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.comparison.reader.delegate.IgnoreHourReader;
import net.sf.esfinge.comparison.reader.delegate.DelegateReader;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@DelegateReader(IgnoreHourReader.class)
public @interface IgnoreHour {

}
