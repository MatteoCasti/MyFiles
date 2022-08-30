package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		float metriQuadri=Float.parseFloat(request.getParameter("metri"));
		float prezzoMetroQuadro=Float.parseFloat(request.getParameter("prezzo"));
		int nBalconi=Integer.parseInt(request.getParameter("balconi"));
		int nRate=Integer.parseInt(request.getParameter("rate"));
		boolean cantina=request.getParameter("cantina").toLowerCase().equalsIgnoreCase("si") ? true : false;
		
		float prezzo=0;
		prezzo+=metriQuadri*prezzoMetroQuadro;
		for(int i=0;i<nBalconi;i++)
			prezzo=prezzo+prezzo*1.05F;
		
		if(cantina)
			prezzo*=1.2F;
		int tasso;
		
		if(nRate<10)
			tasso=5;
		else if(nRate>=10 && nRate<20)
				tasso=8;
		else
			tasso=12;
		float prezzoInteressi=prezzo+prezzo*(tasso/100F);
		
		String ris = "<p>Il prezzo dell'immobile e' " + prezzo + "€</p>";
		ris+="<p>Il prezzo dell'immobile con interessi e' " + prezzoInteressi + "€</p>";
		ris+="<p>Il prezzo di ogni singola rata e' " +prezzoInteressi/nRate + "€</p>";
		
		// Problemi di codifica?
		response.setContentType("charset=UTF-8");
		
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
