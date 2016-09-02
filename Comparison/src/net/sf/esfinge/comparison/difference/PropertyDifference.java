package net.sf.esfinge.comparison.difference;

public class PropertyDifference extends Difference{
	
	private Object newValue;
	private Object oldValue;
	
	public PropertyDifference(String property, Object newValue, Object oldValue) {
		setPath(property);
		this.newValue = newValue;
		this.oldValue = oldValue;
	}
		
	public Object getNewValue() {
		return newValue;
	}
	public void setNewValue(Object newValue) {
		this.newValue = newValue;
	}
	public Object getOldValue() {
		return oldValue;
	}
	public void setOldValue(Object oldValue) {
		this.oldValue = oldValue;
	}

	@Override
	public String toString() {
		return getPath() +" : " +getOldValue() +" / " +getNewValue();
	}
	
}
