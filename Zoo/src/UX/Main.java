package UX;

import java.util.Map;

import elaborazioneDati.Dao;
import elaborazioneDati.Idao;
import entities.Addetto;
import entities.Animale;
import entities.Gabbia;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String nome, String razza, String ddn, boolean carnivoro,int idGabbia
		Idao zoo =new Dao("jdbc:mysql://localhost:3306/zoo?","root","root");
		//zoo.aggiungiAnimale(new Animale("pipistrello","mammifero","2000-01-01",true), 7);
		//System.out.println(zoo.piuVecchio());
		//zoo.licenzia(6);
		//(id,nome,dataassunzione,titolostudio,stipendio,idgabbia)
		//zoo.modificaAddetto(new Addetto(6,"amioo","2015-05-10","bici",1100), 3);
		/*for(Gabbia g : zoo.listaGabbie()) {
			System.out.println(g);
		}*/
		for(Animale g : zoo.listaAnimali("grotta")) {
			System.out.println(g);
		}
		//for(Addetto g : zoo.listaAddetti()) {
			//System.out.println(g);
	//	}
		
		/*Map<Gabbia,Integer> gabbie=zoo.listaGabbieConPiuAnimali();
		for(Gabbia a : gabbie.keySet()) {
			System.out.println(a.getId()+" "+gabbie.get(a));
		}*/

	}

}
