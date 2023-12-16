package sn.swing.entities;

public enum Criticite {
	FAIBLE ("Faible"),
	NORMAL ("Normal"),
	URGENT ("Urgent");
	
	private String name;
	
	private Criticite(String name) {
		this.name = name;
	
	}
	
	public String getName() {
		return name;
	}
	
	 
}
