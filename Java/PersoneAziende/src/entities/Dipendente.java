package entities;

public class Dipendente extends Persona{
	private String mansione;
	private int stipendio;
	
	public Dipendente(int id, String nome, String ddn, String residenza, String mansione, int stipendio) {
		super(id, nome, ddn, residenza);
		this.mansione = mansione;
		this.stipendio = stipendio;
	}
	public Dipendente() {
		
	}
	public Dipendente( String nome, String ddn, String residenza, String mansione, int stipendio) {
		super(nome, ddn, residenza);
		this.mansione = mansione;
		this.stipendio = stipendio;
	}

	public String getMansione() {
		return mansione;
	}

	public void setMansione(String mansione) {
		this.mansione = mansione;
	}

	public int getStipendio() {
		return stipendio;
	}

	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}

	@Override
	public String toString() {
		return "Dipendente [mansione=" + mansione + ", stipendio=" + stipendio + ", toString()=" + super.toString()
				+ "]";
	}

	
	
	
}
