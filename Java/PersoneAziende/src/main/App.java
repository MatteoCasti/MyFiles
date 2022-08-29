package main;

import dao.Dao;
import entities.Azienda;
import entities.Dipendente;
import entities.Persona;
import entities.Ufficio;


public class App extends ConsoleApp{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new App().run();
	}

	
	@Override
	public void run() {
		String cmd;
		Dao dao = new Dao("jdbc:mysql://localhost:3306/personeaziende", "root", "root");
		
		
		
		do {
			/*
				List<Persona> persone()
				List<Dipendente> dipendenti()
				Persona persona(int id)
				Dipendente dipendente(int id)
				int addPersonaGetId(Persona persona)
				void addDipendente(Dipendente dipendente)
				void modificaPersona(Persona persona)
				void modificaDipendente(Dipendente dipendente)
				List<Azienda> aziende() => Nel caso abbiate la proprietà uffici, restituitele senza uffici
				Azienda azienda(int id) => Con gli uffici (uffici senza dipendenti)	
				List<Ufficio> uffici() => senza dipendenti
				List<Ufficio>uffici(int idAzienda) => idem
				Ufficio ufficio(int id) => con i dipendenti
			 * */
			// nextLine ricordo che stampa il msg che arriva da parametro a console 
			// e recupera il valore inserito restituendolo
			System.out.println("Premi: ");
			System.out.println("1) Lista delle persone");
			System.out.println("2) Lista dei dipendenti");
			System.out.println("3) Informazioni su una persona");
			System.out.println("4) Informazioni su un dipendente");
			System.out.println("5) Aggiungere una persona");
			System.out.println("6) Aggiungere un dipendente");
			System.out.println("7) Modificare una persona");
			System.out.println("8) Modificare un dipendente");
			System.out.println("9) Lista aziende");
			System.out.println("10) Azienda con i suoi uffici");
			System.out.println("11) Lista uffici senza dipendenti");
			System.out.println("12) Lista uffici di una determinata azienda");
			System.out.println("13) Un determinato ufficio");
			
			
			
			int scelta = nextInt("Fai la tua scelta!!!","Non hai inserito un'intero");
			
			
			switch(scelta) {
			case 1:
				for(Persona p : dao.persone()) {
					print(p);
				}
				break;
			case 2:
				
				for(Dipendente p : dao.dipendenti()) {
					print(p);
				}
				break;
			case 3:
				int idPersona=nextInt("Inserisci id persona","errore");
				Persona pi=dao.persona(idPersona);
				
				print(pi);
				break;
			case 4:
				int idDip=nextInt("Inserisci id persona","errore");
				Dipendente dip=dao.dipendente(idDip);
				print(dip);
				break;
			case 5:
				dao.addPersonaGetId(new Persona("fausto","1980-03-21","capriccioli"));
				break;
			case 6:
				dao.addDipendente(new Dipendente(7,"joker","1960-12-31","gotham","criminale",10000));
				break;
			case 7:
				dao.modificaPersona(new Persona(1,"alberto","1986-01-02","milano"));
				dao.modificaPersona(new Persona(2,"aldo","1989-04-12","milano"));
				break;
			case 8:
				dao.modificaDipendente(new Dipendente(3,"clara","1999-01-13","milano","programmatore",1333));
				break;
			case 9:
				for(Azienda a : dao.aziende()) {
					print(a);
				}
				break;
			case 10:
				Azienda az=dao.azienda(2);
				print(az);
				break;
			case 11:
				for(Ufficio u : dao.uffici()) {
					print(u);
				}
				break;
			case 12:
				for(Ufficio uf : dao.uffici(2)) {
					print(uf);
				}
				break;
			case 13:
				Ufficio uff = dao.ufficio(1);
				print(uff);
				break;
			default:
				System.out.println("Opzione non riconosciuta");
				break;
			}
			
			cmd=nextLine("Continuare? ----s/n----");
			
		} while (cmd.equalsIgnoreCase("s"));
		
		System.out.println("Programma terminato!!!!");
	}
}
