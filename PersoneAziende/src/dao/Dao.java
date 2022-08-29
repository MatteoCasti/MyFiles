package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entities.Azienda;
import entities.Dipendente;
import entities.Persona;
import entities.Ufficio;

public class Dao extends BasicDao implements IDao {

	public Dao(String dbAddress, String user, String password) {
		super(dbAddress, user, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Persona> persone() {
		List<Persona> persone=new ArrayList<>();
		
		for(Map<String,String> map : getAll("SELECT * FROM persone") ) {
			Persona p=new Persona();
			p.fromMap(map);
			persone.add(p);
		} 
		return persone;
	}

	@Override
	public List<Dipendente> dipendenti() {
		List<Dipendente> dipendenti=new ArrayList<>();
		
		for(Map<String,String> map : getAll("SELECT persone.*,dipendenti.* FROM persone INNER JOIN"
				+ " dipendenti ON persone.id=dipendenti.id") ) {
			Dipendente p=new Dipendente();
			p.fromMap(map);
			dipendenti.add(p);
		} 
		return dipendenti;
		
	}
	private List<Dipendente> dipendenti(int idUfficio) {
		List<Dipendente> dipendenti=new ArrayList<>();
		
		for(Map<String,String> map : getAll("SELECT persone.*,dipendenti.* FROM persone INNER JOIN"
				+ " dipendenti ON persone.id=dipendenti.id INNER JOIN lavoranoin ON dipendenti.id=lavoranoin.iddipendente WHERE lavoranoin.idufficio=?",idUfficio) ) {
			Dipendente p=new Dipendente();
			p.fromMap(map);
			dipendenti.add(p);
		} 
		return dipendenti;
		
	}

	@Override
	public Persona persona(int id) {

		
		Map<String,String> map = getOne("SELECT * FROM persone WHERE id = ?",id);  
		Persona p=new Persona();
		p.fromMap(map);
			
		
		return p;
	}

	@Override
	public Dipendente dipendente(int id) {
		Map<String,String> map = getOne("SELECT persone.*,dipendenti.* FROM persone INNER JOIN"
				+ " dipendenti ON persone.id=dipendenti.id WHERE persone.id=?",id);  
		Dipendente p=new Dipendente();
		p.fromMap(map);
			
		
		return p;
	}

	@Override
	public int addPersonaGetId(Persona persona) {
		execute("Insert into persone (nome,ddn,residenza) values (?,?,?)",persona.getNome(),persona.getDdn(),persona.getResidenza());
		return 0;
	}

	@Override
	public void addDipendente(Dipendente dipendente) {
		addPersonaGetId(new Persona(dipendente.getId(),dipendente.getNome(),dipendente.getDdn(),dipendente.getResidenza()));
		execute("insert into dipendenti (id,mansione,stipendio) values (?,?,?) ",dipendente.getId(),dipendente.getMansione(),dipendente.getStipendio());
		
	}

	@Override
	public void modificaPersona(Persona persona) {
		execute("UPDATE persone SET nome=?,ddn=?,residenza=? WHERE id=?",persona.getNome(),persona.getDdn(),persona.getResidenza(),persona.getId());
		
	}

	@Override
	public void modificaDipendente(Dipendente dipendente) {
		modificaPersona(new Persona(dipendente.getId(),dipendente.getNome(),dipendente.getDdn(),dipendente.getResidenza()));
		execute("UPDATE dipendenti SET mansione=?,stipendio=? ",dipendente.getMansione(),dipendente.getStipendio());
	}

	@Override
	public List<Azienda> aziende() {
		List<Azienda> aziende=new ArrayList<>();
		
		for(Map<String,String> map : getAll("SELECT * FROM aziende") ) {
			Azienda p=new Azienda();
			p.fromMap(map);
			aziende.add(p);
		} 
		return aziende;
	}

	@Override
	public Azienda azienda(int id) {
		Map<String,String> map = getOne("SELECT * FROM aziende WHERE id=?",id);  
			Azienda p=new Azienda();
			p.fromMap(map);
			p.setUffici(uffici(id));
		
		return p;
	}

	@Override
	public List<Ufficio> uffici() {
		List<Ufficio> uffici=new ArrayList<>();
		
		for(Map<String,String> map : getAll("SELECT * FROM uffici") ) {
			Ufficio p=new Ufficio();
			p.fromMap(map);
			uffici.add(p);
		} 
		return uffici;
	}

	@Override
	public List<Ufficio> uffici(int idAzienda) {
		List<Ufficio> uffici=new ArrayList<>();
		
		for(Map<String,String> map : getAll("SELECT * FROM uffici WHERE idazienda=?",idAzienda) ) {
			Ufficio p=new Ufficio();
			p.fromMap(map);
			uffici.add(p);
		} 
		return uffici;
	}

	@Override
	public Ufficio ufficio(int id) {
		Map<String,String> map = getOne("SELECT * FROM uffici WHERE id=?",id) ;
			Ufficio p=new Ufficio();
			p.fromMap(map);
			p.setDipendenti(dipendenti(id));
			
		
		return p;
	}

}
