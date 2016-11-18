package net.sf.esfinge.comparison.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.comparison.reader.delegate.CollectionComparisonReader;
import net.sf.esfinge.comparison.reader.delegate.DeepComparisonReader;
import net.sf.esfinge.comparison.reader.delegate.DelegateReader;


@Retention(RetentionPolicy.RUNTIME)
@DelegateReader(CollectionComparisonReader.class)
public @interface CollectionComparison {

}
