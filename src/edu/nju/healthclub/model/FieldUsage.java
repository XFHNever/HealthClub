package edu.nju.healthclub.model;

public class FieldUsage {
	private String field;
	private long count;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public FieldUsage(String field, long count) {
		super();
		this.field = field;
		this.count = count;
	}
	
	
}
