package net.sf.esfinge.comparison.integration;

import java.util.List;

import net.sf.esfinge.comparison.annotation.CollectionComparison;
import net.sf.esfinge.comparison.annotation.DeepComparison;

public class Bean{

	private List<String> list;
	
	
	private List<IntBean> compList;
	
	@DeepComparison
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	
	
	@CollectionComparison
	@DeepComparison
	public List<IntBean> getCompList() {
		return compList;
	}
	public void setCompList(List<IntBean> compList) {
		this.compList = compList;
	}
}
