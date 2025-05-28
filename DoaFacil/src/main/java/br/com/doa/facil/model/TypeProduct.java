package br.com.doa.facil.model;

public enum TypeProduct {
	LIVRO("Livro"),
	COMIDA("comida"),
	ROUPAS("Roupa"),
	MOVEIS("Móveis"),
	BRINQUEDO("Brinquedo");
	
	private String description;
	
	private TypeProduct(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
