package net.sf.esfinge.comparison.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.comparison.reader.delegate.DelegateReader;
import net.sf.esfinge.comparison.reader.delegate.IgnoreDayReader;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@DelegateReader(IgnoreDayReader.class)
public @interface IgnoreDay {
}
