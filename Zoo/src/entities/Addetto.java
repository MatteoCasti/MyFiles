package entities;

public class Addetto {
	private int id; 
	private String nome; 
	private String dataassunzione;
	private String titolostudio; 
	private int stipendio;
	private int idGabbia;
	
	
	
	public Addetto(int id, String nome, String dataassunzione, String titolostudio, int stipendio,int idGabbia) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataassunzione = dataassunzione;
		this.titolostudio = titolostudio;
		this.stipendio = stipendio;
		this.idGabbia=idGabbia;
	}
	public Addetto(int id, String nome, String dataassunzione, String titolostudio, int stipendio) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataassunzione = dataassunzione;
		this.titolostudio = titolostudio;
		this.stipendio = stipendio;
		this.idGabbia=idGabbia;
	}
	public Addetto( String nome, String dataassunzione, String titolostudio, int stipendio) {
		super();
		this.nome = nome;
		this.dataassunzione = dataassunzione;
		this.titolostudio = titolostudio;
		this.stipendio = stipendio;
	
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



	public String getDataassunzione() {
		return dataassunzione;
	}



	public void setDataassunzione(String dataassunzione) {
		this.dataassunzione = dataassunzione;
	}



	public String getTitolostudio() {
		return titolostudio;
	}



	public void setTitolostudio(String titolostudio) {
		this.titolostudio = titolostudio;
	}



	public int getStipendio() {
		return stipendio;
	}



	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}



	public int getIdGabbia() {
		return idGabbia;
	}



	public void setIdGabbia(int idGabbia) {
		this.idGabbia = idGabbia;
	}



	@Override
	public String toString() {
		return "Addetto [id=" + id + ", nome=" + nome + ", dataassunzione=" + dataassunzione + ", titolostudio="
				+ titolostudio + ", stipendio=" + stipendio + ", idGabbia=" + idGabbia + "]";
	}
	
	
	
	
}
