package net.sf.esfinge.comparison;

public class CompareException extends Exception {

	public CompareException(String msg) {
		super(msg);
	}
	
	public CompareException(String msg, Exception e) {
		super(msg, e);
	}

}
