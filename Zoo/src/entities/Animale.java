package entities;

public class Animale {
	private int id; 
	private String nome; 
	private String razza; 
	private String ddn; 
	private boolean carnivoro;
	private int idGabbia;
	public Animale(int id, String nome, String razza, String ddn, boolean carnivoro,int idGabbia) {
		super();
		this.id = id;
		this.nome = nome;
		this.razza = razza;
		this.ddn = ddn;
		this.carnivoro = carnivoro;
		this.idGabbia=idGabbia;
	}
	public Animale(String nome, String razza, String ddn, boolean carnivoro) {
		super();
		
		this.nome = nome;
		this.razza = razza;
		this.ddn = ddn;
		this.carnivoro = carnivoro;
		this.idGabbia=idGabbia;
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
	public String getRazza() {
		return razza;
	}
	public void setRazza(String razza) {
		this.razza = razza;
	}
	public String getDdn() {
		return ddn;
	}
	public void setDdn(String ddn) {
		this.ddn = ddn;
	}
	public boolean isCarnivoro() {
		return carnivoro;
	}
	public void setCarnivoro(boolean carnivoro) {
		this.carnivoro = carnivoro;
	}
	public int getIdGabbia() {
		return idGabbia;
	}
	public void setIdGabbia(int idGabbia) {
		this.idGabbia = idGabbia;
	}
	@Override
	public String toString() {
		return "Animale [id=" + id + ", nome=" + nome + ", razza=" + razza + ", ddn=" + ddn + ", carnivoro=" + carnivoro
				+ ", idGabbia=" + idGabbia + "]";
	}
	
	
	
	
	
}