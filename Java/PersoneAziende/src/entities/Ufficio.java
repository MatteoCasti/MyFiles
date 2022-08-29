package entities;

import java.util.List;

public class Ufficio implements IMappablePro{
	
	private int id;
	private String categoria;
	private List<Dipendente> dipendenti;
	
	public Ufficio(int id, String categoria, List<Dipendente> dipendenti) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.dipendenti = dipendenti;
	}
	
	public Ufficio(){
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Dipendente> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(List<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}

	@Override
	public String toString() {
		return "Ufficio [id=" + id + ", categoria=" + categoria + ", dipendenti=" + dipendenti + "]";
	}
	
	
	
	

}
