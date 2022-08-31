package model;

import java.util.List;

public interface IDaoProdotti {
	/*Un metodo che restituisce la lista dei prodotti
	Un metodo che attraverso un indice restituisce un singolo prodotto
	Un metodo che aggiunge un prodotto alla lista
	Un metodo che elimina un prodotto dalla lista
	Un metodo che modifica un prodotto della lista
	======BONUS======

	Un metodo che restituisce solo i prodotti di una determinata categoria
	*/
	
	List<Prodotto> listaProdotti();
	List<Prodotto> listaProdotti(String categoria);
	Prodotto prodotto(int indice);
	void aggiungi(Prodotto p);
	void elimina(int indice);
	void modifica(Prodotto p, int indice);
}
