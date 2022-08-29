package entities;

public class Persona implements IMappablePro{
	private int id;
	private String nome;
	private String ddn;
	private String residenza;
	
	public Persona(int id, String nome, String ddn, String residenza) {
		super();
		this.id = id;
		this.nome = nome;
		this.ddn = ddn;
		this.residenza = residenza;
	}
	public Persona(String nome, String ddn, String residenza) {
		super();
		
		this.nome = nome;
		this.ddn = ddn;
		this.residenza = residenza;
	}

	public Persona() {
		
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

	public String getDdn() {
		return ddn;
	}

	public void setDdn(String ddn) {
		this.ddn = ddn;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", ddn=" + ddn + ", residenza=" + residenza + "]";
	}
	
	

}
