package view;

import java.util.List;

import model.Prodotto;

public interface IView {
	
	String renderHome();
	String render(List<Prodotto> prodotti);
	String renderCategoria(List<Prodotto> prodotti,	String categoria);
	String render(Prodotto prodotto);
	String renderModifica(Prodotto persona, int indice);
}
