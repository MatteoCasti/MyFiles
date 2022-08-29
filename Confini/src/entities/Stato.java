package entities;

public class Stato {
	private  int id;
	private String nome; 
	private int popolazione;
	private String moneta;
	private String religioneufficiale;
	public Stato(int id, String nome, int popolazione, String moneta, String religioneufficiale) {
		super();
		this.id = id;
		this.nome = nome;
		this.popolazione = popolazione;
		this.moneta = moneta;
		this.religioneufficiale = religioneufficiale;
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
	public int getPopolazione() {
		return popolazione;
	}
	public void setPopolazione(int popolazione) {
		this.popolazione = popolazione;
	}
	public String getMoneta() {
		return moneta;
	}
	public void setMoneta(String moneta) {
		this.moneta = moneta;
	}
	public String getReligioneufficiale() {
		return religioneufficiale;
	}
	public void setReligioneufficiale(String religioneufficiale) {
		this.religioneufficiale = religioneufficiale;
	}
	@Override
	public String toString() {
		return "Stato [id=" + id + ", nome=" + nome + ", popolazione=" + popolazione + ", moneta=" + moneta
				+ ", religioneufficiale=" + religioneufficiale + "]";
	}
	
	
}
