package entities;

import java.util.List;

public class Azienda implements IMappablePro {
	private int id;
	private String nome;
	private String indirizzo;
	private int budget;
	private List<Ufficio> uffici;
	
	public Azienda(int id, String nome, String indirizzo, int budget, List<Ufficio> uffici) {
		super();
		this.id = id;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.budget = budget;
		this.uffici = uffici;
	}
	
	public Azienda() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public List<Ufficio> getUffici() {
		return uffici;
	}

	public void setUffici(List<Ufficio> uffici) {
		this.uffici = uffici;
	}

	@Override
	public String toString() {
		return "Azienda [id=" + id + ", nome=" + nome + ", indirizzo=" + indirizzo + ", budget=" + budget + ", uffici="
				+ uffici + "]";
	}
	
	
	
}
