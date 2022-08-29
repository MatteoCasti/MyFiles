package Dao;

import java.util.List;
import java.util.Map;

import entities.Stato;

public interface Idao {

	
	/*
	 *  l'elenco di tutti gli stati
		il dettaglio di uno stato con tutte le informazioni sugli stati confinanti (comprensivo della lunghezza)
		aggiungere uno stato
		modificare uno stato
		aggiungere uno stato confinante ad uno stato
		cancellare uno stato (attenzione che devo eliminare il confine con gli altri stati)
		voglio sapere di un determinato stato qual è lo stato che con lui ha il confine più lungo
		voglio sapere di un determinato stato quali sono gli stati che hanno una religione ufficiale diversa da quella dello stato stesso
		voglio sapere la somma delle popolazioni di uno stato e degli stati con lui confinanti.
	 * */
	
	List<Stato> listaStati();
	void aggiungiStato(Stato s);
	void updateStato(Stato s, int idStato);
	void aggiungiStato(Stato s,int idStato,int lConfine);
	void deleteStato(int idStato);
	Map<String,Integer> confineLungo(int idStato);
	List<Stato> religioneDiversaRispetto(int idStato);
	int popolazioneTotale(int idStato);
	
	
}
