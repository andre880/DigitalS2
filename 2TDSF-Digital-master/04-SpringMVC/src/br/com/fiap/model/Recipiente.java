package br.com.fiap.model;

public enum Recipiente {

	LATA("Lata"), GARRAFA("Garrafa");
	
	private String label;
	
	private Recipiente(String label){
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
