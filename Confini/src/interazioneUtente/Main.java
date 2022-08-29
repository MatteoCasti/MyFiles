package interazioneUtente;

import Dao.Dao;
import Dao.Idao;
import entities.Stato;

public class Main {

	public static void main(String[] args) {
		
		
		Idao confini=new Dao("jdbc:mysql://localhost:3306/stati?","root","root");
		
		
		for(Stato s: confini.listaStati()) {
			System.out.println(s);
		}
	}

}
