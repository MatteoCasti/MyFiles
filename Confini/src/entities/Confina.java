package entities;

public class Confina {
	private int id; 
	private int idstato1;
	private int idstato2;
	private int lunghezza;
	public Confina(int id, int idstato1, int idstato2, int lunghezza) {
		super();
		this.id = id;
		this.idstato1 = idstato1;
		this.idstato2 = idstato2;
		this.lunghezza = lunghezza;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdstato1() {
		return idstato1;
	}
	public void setIdstato1(int idstato1) {
		this.idstato1 = idstato1;
	}
	public int getIdstato2() {
		return idstato2;
	}
	public void setIdstato2(int idstato2) {
		this.idstato2 = idstato2;
	}
	public int getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}
	@Override
	public String toString() {
		return "Confina [id=" + id + ", idstato1=" + idstato1 + ", idstato2=" + idstato2 + ", lunghezza=" + lunghezza
				+ "]";
	}
	
	
}
