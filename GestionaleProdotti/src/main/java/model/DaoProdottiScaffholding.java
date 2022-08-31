package model;

import java.util.ArrayList;
import java.util.List;

public class DaoProdottiScaffholding implements IDaoProdotti {
	
	private List<Prodotto> prodotti;

	public DaoProdottiScaffholding() {
		super();
		prodotti=new ArrayList<>();
		prodotti.add(new Prodotto("shampoo","clear","articoli bagno",3.99,300));
		prodotti.add(new Prodotto("pane","piras","alimentari",1.99,100));
		prodotti.add(new Prodotto("bullone","inox","meccanica",0.99,10));
		prodotti.add(new Prodotto("libro","mondadori","cultura",23.99,400));
		
	}

	@Override
	public List<Prodotto> listaProdotti() {
		// TODO Auto-generated method stub
		return prodotti;
	}

	@Override
	public List<Prodotto> listaProdotti(String categoria) {
		List<Prodotto> prodottiCategoria=new ArrayList<>();
		
		for(Prodotto p : prodotti) {
			if(p.getCategoria().toLowerCase().equalsIgnoreCase(categoria.toLowerCase()))
				prodottiCategoria.add(p);
		}
		return prodottiCategoria;
	}

	@Override
	public Prodotto prodotto(int indice) {
		// TODO Auto-generated method stub
		return prodotti.get(indice);
	}

	@Override
	public void aggiungi(Prodotto p) {
		// TODO Auto-generated method stub
		prodotti.add(p);
		
	}

	@Override
	public void elimina(int indice) {
		prodotti.remove(indice);
		
	}

	@Override
	public void modifica(Prodotto p, int indice) {
		prodotti.set(indice, p);
		
	}
	
	
	
}
