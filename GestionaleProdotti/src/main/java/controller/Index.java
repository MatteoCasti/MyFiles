package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DaoProdottiScaffholding;
import model.IDaoProdotti;
import model.Prodotto;
import view.IView;
import view.View;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IDaoProdotti dao;
    private IView view;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
        dao=new DaoProdottiScaffholding();
        view=new View();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ris="";
		String cmd=request.getParameter("cmd");
		if(cmd==null) {
        	cmd="home";
        	
        }
		switch(cmd) {
		case "home":
			ris=view.renderHome();
			break;
		case "prodotti":
			ris=view.render(dao.listaProdotti());
			break;
		case "dettaglio":
			int indice=Integer.parseInt(request.getParameter("indice"));
			ris=view.render(dao.prodotto(indice));
			break;
		case "aggiungi":
			String nome=request.getParameter("nome");
			String categoria=request.getParameter("categoria");
			String marca=request.getParameter("marca");
			double prezzo=Double.parseDouble(request.getParameter("prezzo"));
			int peso=Integer.parseInt(request.getParameter("peso"));
			dao.aggiungi(new Prodotto(nome,marca,categoria,prezzo,peso));
			response.sendRedirect("Index?cmd=prodotti");
			break;
		case "elimina":
			int index=Integer.parseInt(request.getParameter("indice"));
			dao.elimina(index);
			response.sendRedirect("Index?cmd=prodotti");
			break;
		case "gotomodifica":
			int inde=Integer.parseInt(request.getParameter("indice"));
			Prodotto p=dao.prodotto(inde);
			ris=view.renderModifica(p, inde);
			break;
		case "modifica":
			int ind=Integer.parseInt(request.getParameter("indice"));
			String nom=request.getParameter("nome");
			String categori=request.getParameter("categoria");
			String marc=request.getParameter("marca");
			double prezz=Double.parseDouble(request.getParameter("prezzo"));
			int pes=Integer.parseInt(request.getParameter("peso"));
			dao.modifica(new Prodotto(nom,marc,categori,prezz,pes), ind);
			response.sendRedirect("Index?cmd=prodotti");
			break;
		}
		
		
		response.setContentType("text/html");
		
		response.getWriter().append(ris);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
