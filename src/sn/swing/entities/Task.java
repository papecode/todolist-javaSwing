package sn.swing.entities;

import java.time.LocalDate;

public class Task {
	private int reference;
	private String description; 
	private LocalDate dateEcheance; 
	private Criticite criticite;
	
	
	
	public Task(String description, LocalDate dateEcheance, Criticite criticite) {
		this.description = description;
		this.dateEcheance = dateEcheance;
		this.criticite = criticite;
		// - defined
		this.reference = -1;
	}

	public Task(int reference, String description, LocalDate dateEcheance, Criticite criticite) {
		super();
		this.setReference(reference);
		this.description = description;
		this.dateEcheance = dateEcheance;
		this.criticite = criticite;
	}

	public int getReference() {
		return reference;
	}
	
	public void setReference(int reference) {
		if( reference > 0)
			this.reference = reference;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDate getDateEcheance() {
		return dateEcheance;
	}
	
	public void setDateEcheance(LocalDate dateEcheance) {
		this.dateEcheance = dateEcheance;
	}
	
	public Criticite getCriticite() {
		return criticite;
	}
	
	public void setCriticite(Criticite criticite) {
		this.criticite = criticite;
	} 
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Task) {
			return this.reference == ((Task)obj).reference;
		} else {
			return false;
		}
	}
	
	
	
	
}
