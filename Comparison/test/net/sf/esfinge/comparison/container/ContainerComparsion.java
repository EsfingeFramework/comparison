package net.sf.esfinge.comparison.container;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import net.sf.esfinge.comparison.reader.delegate.DelegateReader;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.MethodProcessors;
import net.sf.esfinge.metadata.annotation.container.Processors;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.TYPE)
public class ContainerComparsion {
	
	@MethodProcessors(DelegateReader.class)
	Map<Method,Object> processorMethods;

	public Map<Method, Object> getProcessorMethods() {
		return processorMethods;
	}

	public void setProcessorMethods(Map<Method, Object> processorMethods) {
		this.processorMethods = processorMethods;
	}

	
	
	
	
}
