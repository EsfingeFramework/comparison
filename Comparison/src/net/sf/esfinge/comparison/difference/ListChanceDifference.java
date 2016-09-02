package net.sf.esfinge.comparison.difference;

public class ListChanceDifference extends Difference{
	
	private Object item;
	private ListChange changeType;
	
	public ListChanceDifference(String path, Object item, ListChange changeType) {
		setPath(path);
		this.item = item;
		this.changeType = changeType;
	}
	
	public Object getItem() {
		return item;
	}
	public void setItem(Object item) {
		this.item = item;
	}
	public ListChange getChangeType() {
		return changeType;
	}
	public void setChangeType(ListChange changeType) {
		this.changeType = changeType;
	}
	
	@Override
	public String toString() {
		return getPath() +" - " + changeType.name() + " - " + item.toString();
	}

}
