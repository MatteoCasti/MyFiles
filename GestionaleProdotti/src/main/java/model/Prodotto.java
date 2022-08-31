package model;

public class Prodotto {
	
	private String nome;
	private String marca;
	private String categoria;
	private double prezzo;
	private int peso;
	
	public Prodotto(String nome, String marca, String categoria, double prezzo, int peso) {
		
		this.nome = nome;
		this.marca = marca;
		this.categoria = categoria;
		this.prezzo = prezzo;
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Prodotti [nome=" + nome + ", marca=" + marca + ", categoria=" + categoria + ", prezzo=" + prezzo
				+ ", peso=" + peso + "]";
	}
	
	
	
	
	
}
