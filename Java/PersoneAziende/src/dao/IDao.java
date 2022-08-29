package dao;

import java.util.List;

import entities.Azienda;
import entities.Dipendente;
import entities.Persona;
import entities.Ufficio;

public interface IDao {

	List<Persona> persone();
	List<Dipendente> dipendenti();
	Persona persona(int id);
	Dipendente dipendente(int id);
	int addPersonaGetId(Persona persona);
	void addDipendente(Dipendente dipendente);
	void modificaPersona(Persona persona);
	void modificaDipendente(Dipendente dipendente);
	List<Azienda> aziende();// => Nel caso abbiate la proprietà uffici, restituitele senza uffici
	Azienda azienda(int id);// => Con gli uffici (uffici senza dipendenti)
	List<Ufficio> uffici();// => senza dipendenti
	List<Ufficio>uffici(int idAzienda);// => idem
	Ufficio ufficio(int id);// => con i dipendenti
}
