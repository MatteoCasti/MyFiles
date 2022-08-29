package elaborazioneDati;
import java.util.List;
import java.util.Map;

import entities.Addetto;
import entities.Animale;
import entities.Gabbia;

public interface Idao {
	

	
	 List<Gabbia> listaGabbie();
	 List<Animale> listaAnimali();
	 List<Addetto> listaAddetti();
	 List<Gabbia> listaGabbieConAddetti();
	 List<Gabbia> listaGabbieConAnimali();
	 List<Addetto> listaAddettiConGabbia();
	 Animale dettaglioAnimale(int id);
	 void aggiungiAddetto(Addetto a,int idGabbia);
	 void modificaAddetto(Addetto a,int idGabbia);
	 void modificaAddetto(int idAddetto,int idGabbia);
	 void cancellaGabbia(int idGabbia);
	 void licenzia(int idAddetto);
	 Map<Gabbia,Integer> listaGabbieConCostoAddetti();
	 Map<Gabbia,Integer> listaGabbieConPiuAnimali();
	 void aggiungiGabbia(Gabbia g);
	 void aggiungiAnimale(Animale a, int idGabbia);
	 Addetto piuVecchio();
	 List<Animale> listaAnimali(String habitat);
	/*

	

	
	
	permettere di aggiungere un nuovo animale (devo assegnarlo subito ad una gabbia)
	voglio conoscere l'addetto assunto da più tempo
	voglio l'elenco degli animali di un determinato habitat*/
	

}
