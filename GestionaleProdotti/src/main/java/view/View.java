package view;

import java.util.List;

import model.Prodotto;

public class View implements IView{
	
	private String strutturaPagina(){
		return "<html>"
				+ "<head><title>Magazzino</title></head>"
				+ "<body> [BODY] </body>"
				+ "</html>";
	}
	@Override
	public String renderHome() {
		// TODO Auto-generated method stub
		String ris =strutturaPagina();
		String body= "<h1>Magazzino</h1>"
				   + "<h2>Benvenuti nel magazzino</h2>"
				   + "<a href='Index?cmd=prodotti'>Lista</a>";
				   
		return ris.replace("[BODY]", body);
		
	}

	@Override
	public String render(List<Prodotto> prodotti) {
		
		String ris =strutturaPagina();
		String body= "<h1><a href='Index?cmd=prodotti'>Magazzino</a></h1>"
				+"<p><b>Inserisci un elemento</b></p>"
				+ "<form action='Index' method='GET'>"
				+ "<input type='hidden' name='cmd' value='aggiungi'>"
				+ "<p>Nome:</p>"
				+ "<input type='text' name='nome'>"
				+ "<p>Marca</p>"
				+ "<input type='text' name='marca'>"
				+ "<p>Categoria</p>"
				+ "<input type='text' name='categoria'>"
				+ "<p>Prezzo</p>"
				+ "<input type='number' step='0.01' name='prezzo'>"
				+ "<p>Peso</p>"
				+ "<input type='number'  name='peso'>"
				+ "<br><br>"
				+ "<button>Aggiungi</button>"
				+ "<button type='reset'>Reset</button>"
				+ "</form><br><br>"
				+"<p>Elementi In Magazzino";
		body+="<ul>";
		int i=0;
		for(Prodotto p : prodotti) {
			body+="<li><a href='Index?cmd=dettaglio&indice=" + i + "' >"+p.getNome()+"</a>---"
					+"<a href='Index?cmd=gotomodifica&indice=" + i + "' >Modifica</a>---"
					+"<button><a href='Index?cmd=elimina&indice=" + i + "' >&times;</a></button>---"
					+"</li>";
			i++;
		}
		body+="</ul>";
		return ris.replace("[BODY]", body);
		
	}
public String renderCategoria(List<Prodotto> prodotti, String categoria) {
		
		String ris =strutturaPagina();
		String body= "<h1><a href='Index?cmd=prodotti'>Magazzino</a></h1>"
				+"<p><b>Inserisci un elemento</b></p>"
				+ "<form action='Index' method='GET'>"
				+ "<input type='hidden' name='cmd' value='aggiungi'>"
				+ "<p>Nome:</p>"
				+ "<input type='text' name='nome'>"
				+ "<p>Marca</p>"
				+ "<input type='text' name='marca'>"
				+ "<p>Categoria</p>"
				+ "<input type='text' name='categoria'>"
				+ "<p>Prezzo</p>"
				+ "<input type='number' step='0.01' name='prezzo'>"
				+ "<p>Peso</p>"
				+ "<input type='number' name='peso'>"
				+ "<br><br>"
				+ "<button>Aggiungi</button>"
				+ "<button type='reset'>Reset</button>"
				+ "</form>";
		body+="<p>"+categoria+"</p><ul>";
		int i=0;
		for(Prodotto p : prodotti) {
			body+="<li><a href='Index?cmd=dettaglio&indice=" + i + "' >"+p.getNome()+"</a>---"
					+"<a href='Index?cmd=gotomodifica&indice=" + i + "' >Modifica</a>---"
					+"<button><a href='Index?cmd=elimina&indice=" + i + "' >&times;</a></button>---"
					+"</li>";
			i++;
		}
		body+="</ul>";
		ris.replace("[BODY]", body);
		return ris;
	}

	@Override
	public String render(Prodotto prodotto) {
		// TODO Auto-generated method stub
		String ris =strutturaPagina();
		String  body= "<h1><a href='Index?cmd=prodotti'>Magazzino</a></h1><h2>Dettaglio Prodotto</h2>";
				body+="<p>Nome: "+prodotto.getNome()+"</p>";
				body+="<p>Categoria: "+prodotto.getCategoria()+"</p>";
				body+="<p>Marca: "+prodotto.getMarca()+"</p>";
				body+="<p>Prezzo: "+prodotto.getPrezzo()+" £</p>";
				body+="<p>Peso: "+prodotto.getPeso()+" g</p>";
		return ris.replace("[BODY]", body);
		
	}

	@Override
	public String renderModifica(Prodotto persona, int indice) {
		// TODO Auto-generated method stub
		String ris =strutturaPagina();
		String body= "<h1><a href='Index?cmd=prodotti'>Magazzino</a></h1>"
		+"<p><b>Inserisci un elemento</b></p>"
		+ "<form action='Index' method='GET'>"
		+ "<input type='hidden' name='cmd' value='modifica'>"
		+ "<input type='hidden' name='indice' value='" + indice + "'>"
		+ "<p>Nome:</p>"
		// Negli input dovranno essere precarticati i vecchi dati della persona da modificare
		+ "<input type='text' name='nome' value='" + persona.getNome() + "'>"
		+ "<p>Categoria:</p>"
		+ "<input type='text' name='categoria' value='" + persona.getCategoria() + "'>"
		+ "<p>Marca:</p>"
		+ "<input type='text' name='marca' value='" + persona.getMarca() + "'>"
		+ "<p>Prezzo:</p>"
		+ "<input type='number' step='0.01' name='prezzo' value='" + persona.getPrezzo() + "'>"
		+ "<p>Peso:</p>"
		+ "<input type='number' name='peso' value='" + persona.getPeso() + "'>"
		+ "<br><br>"
		+ "<button>Modifica</button>"
		+ "</form>";
		
		return ris.replace("[BODY]", body);
		
	}

}
