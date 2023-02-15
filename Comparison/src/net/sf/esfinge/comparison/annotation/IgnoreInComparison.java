package net.sf.esfinge.comparison.annotation;

import net.sf.esfinge.metadata.locate.conventions.annotations.PrefixConvention;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@PrefixConvention(value = "getIgnore")
public @interface IgnoreInComparison{}
