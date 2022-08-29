package elaborazioneDati;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Addetto;
import entities.Animale;

import entities.Gabbia;

public class Dao implements Idao{
	private String dbAddress;
	private String nomeUtente;
	private String password;
	
	
	
	public Dao(String dbAddress, String nomeUtente, String password) {
		super();
		this.dbAddress = dbAddress;
		this.nomeUtente = nomeUtente;
		this.password = password;
	}
	
	private List<Gabbia> listaGabbieConnection(String query){
			Connection connection=null;
			ArrayList<Gabbia> gabbie=null;
			if(query.toLowerCase().contains("select")) {
			 gabbie=new ArrayList<>();
			try {
			connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
			PreparedStatement statement=connection.prepareStatement(query);
			
					
					
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				Gabbia d=new Gabbia(result.getInt("id"),result.getInt("numerogabbia"),result.getString("tipoabitat"));
				gabbie.add(d);
			}

			
			
			} catch (SQLException e) {
			System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
			e.printStackTrace();
			}finally {
				try {
					if (!connection.isClosed()) {
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}else {
			
			try {
				connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
				PreparedStatement statement = connection.prepareStatement(query);
				statement.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if (!connection.isClosed()) {
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
					
					
			
		}
			return gabbie;
	}
	
	
	@Override
	public List<Gabbia> listaGabbie() {
	
		return listaGabbieConnection("SELECT * FROM gabbie");
	}
	
	
	private List<Animale> listaAnimaliConnection(String query){
		Connection connection=null;
		ArrayList<Animale> animali=null;
		if(query.toLowerCase().contains("select")) {
			animali=new ArrayList<>();
		try {
		connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
		PreparedStatement statement=connection.prepareStatement(query);
		
				
				
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			Animale d=new Animale(result.getInt("id"),result.getString("nome"),result.getString("razza"),result.getString("ddn"),result.getBoolean("carnivoro"),result.getInt("idgabbia"));
			animali.add(d);
		}

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}else {
		
		try {
			connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
			PreparedStatement statement = connection.prepareStatement(query);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
				
				
		
	}
		return animali;
}

	

	@Override
	public List<Animale> listaAnimali() {
		return listaAnimaliConnection("SELECT * FROM animali");
	}

	private ArrayList<Addetto> listaAddettiConnection(String query) {
		Connection connection=null;
		ArrayList<Addetto> addetti=null;
		if(query.toLowerCase().contains("select")) {
			addetti=new ArrayList<>();
		try {
		connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
		PreparedStatement statement=connection.prepareStatement(query);
		
				
				
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			Addetto d=new Addetto(result.getInt("id"),result.getString("nome"),result.getString("dataassunzione"),result.getString("titolostudio"),result.getInt("stipendio"),result.getInt("idgabbia"));
			addetti.add(d);
		}

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}else {
		
		try {
			connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
			PreparedStatement statement = connection.prepareStatement(query);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
				
				
		
	}
		return addetti;
	}
		
	
	@Override
	public List<Addetto> listaAddetti() {
		return listaAddettiConnection("SELECT * FROM addetti");
	}
	
	private ArrayList<Addetto> listaAddettiConnection(String query,int idGabbia) {
		Connection connection=null;
		ArrayList<Addetto> addetti=new ArrayList<>();
		try {
		connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
		PreparedStatement statement=connection.prepareStatement(query);
		
	
		statement.setInt(1,idGabbia);
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			Addetto d=new Addetto(result.getInt("id"),result.getString("nome"),result.getString("dataassunzione"),result.getString("titolostudio"),result.getInt("stipendio"),result.getInt("idgabbia"));
			addetti.add(d);
		}

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
		return addetti;
	}
	
	public ArrayList<Addetto> listaAddettiId(int idGabbia) {
		return listaAddettiConnection("SELECT * FROM addetti WHERE idgabbia is not null and idgabbia = ?",idGabbia);
	}
	
	private ArrayList<Gabbia> listaGabbieConAddettiConnection(String query){
	Connection connection=null;
	ArrayList<Gabbia> gabbie=new ArrayList<>();
	try {
	connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
	PreparedStatement statement=connection.prepareStatement(query);
	
			
			
	ResultSet result=statement.executeQuery();
	while(result.next()) {
		ArrayList<Addetto> addetti=listaAddettiId(result.getInt("id"));
		Gabbia d=new Gabbia(result.getInt("id"),result.getInt("numerogabbia"),addetti,result.getString("tipoabitat"));
		gabbie.add(d);
	}

	
	
	} catch (SQLException e) {
	System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
	e.printStackTrace();
	}finally {
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return gabbie;
	
}

	@Override
	public List<Gabbia> listaGabbieConAddetti() {
		return listaGabbieConAddettiConnection("SELECT * FROM gabbie");
	}
	
	private ArrayList<Animale> listaAnimaliId(int idGabbia) {
		return listaAnimaliConnection("SELECT * FROM animali WHERE idgabbia= ?",idGabbia);
	}
	
	
	private ArrayList<Animale> listaAnimaliConnection(String query,int idGabbia) {
		Connection connection=null;
		ArrayList<Animale> animali=new ArrayList<>();
		try {
		connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
		PreparedStatement statement=connection.prepareStatement(query);
		
				
		statement.setInt(1,idGabbia);
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			Animale d=new Animale(result.getInt("id"),result.getString("nome"),result.getString("razza"),result.getString("ddn"),result.getBoolean("carnivoro"),result.getInt("idgabbia"));
			animali.add(d);
		}

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
		
				
				
		
	
		return animali;
	}
	
	private ArrayList<Gabbia> listaGabbieConAnimaliConnection(String query){
		Connection connection=null;
		ArrayList<Gabbia> gabbie=new ArrayList<>();
		try {
		connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
		PreparedStatement statement=connection.prepareStatement(query);
		
				
				
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			ArrayList<Animale> animali=listaAnimaliId(result.getInt("id"));
			Gabbia d=new Gabbia(result.getInt("id"),result.getInt("numerogabbia"),result.getString("tipoabitat"),animali);
			gabbie.add(d);
		}

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return gabbie;
		
	}
	

	@Override
	public List<Gabbia> listaGabbieConAnimali() {
		return listaGabbieConAnimaliConnection("SELECT * FROM gabbie");
	}

	@Override
	public List<Addetto> listaAddettiConGabbia() {
		return listaAddettiConnection("SELECT * "
				+ "FROM addetti RIGHT JOIN gabbie ON addetti.idgabbia=gabbie.id "
				+ "WHERE addetti.idgabbia IS  NOT null");
	}
	
	private ArrayList<Animale> listaAnimaliById(int idGabbia) {
		return listaAnimaliConnection("SELECT * FROM animali WHERE id= ?",idGabbia);
	}
	@Override
	public Animale dettaglioAnimale(int id) {
		Animale an=null;
		for(Animale a :listaAnimaliById(id)) {
			an =  a;
			break;
		}
		return an;
	}

	private void aggiungiAddettoConnection(String query,Addetto a, int idGabbia) {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, a.getNome());
			statement.setString(2, a.getDataassunzione());
			statement.setString(3, a.getTitolostudio());
			statement.setInt(4, a.getStipendio());
			statement.setInt(5, idGabbia);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void aggiungiAddettoConnection(String query, int idGabbia, Addetto a) {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
			PreparedStatement statement = connection.prepareStatement(query);
			
				statement.setInt(1, a.getId());
				statement.setString(2, a.getNome());
				statement.setString(3, a.getDataassunzione());
				statement.setString(4, a.getTitolostudio());
				statement.setInt(5, a.getStipendio());
				statement.setInt(6, idGabbia);
				statement.setInt(7, a.getId());
				statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	private void aggiungiAddettoConnection(String query, int idGabbia,int idAddetto) {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
			PreparedStatement statement = connection.prepareStatement(query);
			
				statement.setInt(1, idGabbia);
				statement.setInt(2, idAddetto);
				
				statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void aggiungiAddetto(Addetto a, int idGabbia) {
		aggiungiAddettoConnection("INSERT INTO addetti (nome,dataassunzione,titolostudio,stipendio,idgabbia) values (  ? , ? ,? , ?, ?)",a,idGabbia); 
		
	}

	@Override
	public void modificaAddetto(Addetto a, int idGabbia) {
		aggiungiAddettoConnection("UPDATE addetti set id= ?, nome=?,dataassunzione=?,titolostudio=?,stipendio= ? ,idgabbia= ? WHERE id= ?",idGabbia,a);
	}
	@Override
	public void modificaAddetto(int idAddetto, int idGabbia) {
		aggiungiAddettoConnection("UPDATE addetti set idgabbia= ? WHERE id= ?",idGabbia,idAddetto);
	}

	private void updateGabbiaConnection(String query, int idGabbia) {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idGabbia);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void cancellaGabbia(int idGabbia) {
		updateGabbiaConnection("DELETE FROM gabbie WHERE id=?",idGabbia);
		
	}
	private void updateAddetto(String query, int idAddetto) {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idAddetto);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} 
	@Override
	public void licenzia(int idAddetto) {
		
		updateAddetto("UPDATE addetti SET idgabbia=null WHERE id=?",idAddetto);
	}
	private Map<Gabbia,Integer> listaGabbieConCostoAddettiConnection(String query){
		Connection connection=null;
		HashMap<Gabbia,Integer> gabbie=new HashMap<>();
		try {
		connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
		PreparedStatement statement=connection.prepareStatement(query);
		
				
				
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			Gabbia d=new Gabbia(result.getInt("gabbie.id"),result.getInt("gabbie.numerogabbia"),result.getString("gabbie.tipoabitat"));
			
			gabbie.put(d, result.getInt("costo"));
		}

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	return gabbie;
	}
	@Override
	public Map<Gabbia,Integer> listaGabbieConCostoAddetti() {
		return listaGabbieConCostoAddettiConnection("SELECT *, SUM(addetti.stipendio) as costo FROM gabbie INNER JOIN addetti ON gabbie.id=addetti.idgabbia WHERE addetti.idgabbia IS NOT null GROUP BY gabbie.id");
	}

	
	private Map<Gabbia,Integer> listaGabbieConPiuAnimaliConnection(String query){
		Connection connection=null;
		HashMap<Gabbia,Integer> gabbie=new HashMap<>();
		try {
		connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
		PreparedStatement statement=connection.prepareStatement(query);
		
				
				
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			Gabbia d=new Gabbia(result.getInt("gabbie.id"),result.getInt("gabbie.numerogabbia"),result.getString("gabbie.tipoabitat"));
			
			gabbie.put(d, result.getInt("conteggio"));
		}

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	return gabbie;
	}
	@Override
	public Map<Gabbia,Integer> listaGabbieConPiuAnimali() {
		return listaGabbieConPiuAnimaliConnection("select count(animali.id) as conteggio, gabbie.* "
							 +"from gabbie inner join animali on gabbie.id=animali.idgabbia "
							 +"where animali.idgabbia is not null "
							 +"group by gabbie.id "
							 +"having conteggio=(	select max(conta )" 
							 						+"from(select count(animali.id) as conta"
							 							+" from gabbie inner join animali on gabbie.id=animali.idgabbia"
							 							+" where idgabbia is not null"
							 							+" group by gabbie.id) as conteggio_dip)");
	}

	private void updateGabbia(String query,Gabbia g) {
		Connection connection=null;
		
		
		
		try {
		connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
		PreparedStatement statement=connection.prepareStatement(query);
		
		statement.setInt(1,g.getId());
		statement.setInt(2,g.getNumerogabbia());
		statement.setString(3, g.getTipoabitat());
				
		statement.execute();
		

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
	}
	
	@Override
	public void aggiungiGabbia(Gabbia g) {

		updateGabbia("INSERT INTO gabbie (id, numerogabbia,tipoabitat) values ( ? ,  ? , ? )",g);
		
	}
	
	private void updateAnimale(String query, Animale a,int idGabbia) {
	Connection connection=null;
		
		
		
		try {
		connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
		PreparedStatement statement=connection.prepareStatement(query);
		
	
		statement.setString(1, a.getNome());
		statement.setString(2, a.getRazza());
		statement.setString(3, a.getDdn());
		statement.setBoolean(4, a.isCarnivoro());
		statement.setInt(5, idGabbia);
		statement.execute();
		

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
	}
	

	@Override
	public void aggiungiAnimale(Animale a, int idGabbia) {
		updateAnimale("INSERT INTO animali (nome,razza,ddn,carnivoro,idgabbia) values"
					 +" (  ? , ? , ? , ? , ? )",a,idGabbia);
		
	}

	@Override
	public Addetto piuVecchio() {
		Addetto b=null;
		for(Addetto a : listaAddettiConnection("select * from addetti where (timestampdiff(year,dataassunzione,now()))=(select max(timestampdiff(year,dataassunzione,now())) as eta_massima from addetti )")) {
			
			b=a;
			break;
			
		}
		return b;
	}

	private List<Animale> listaAnimaliConnection(String query,String habitat){
		Connection connection=null;
		ArrayList<Animale> animali=null;
		
			animali=new ArrayList<>();
		try {
		connection=DriverManager.getConnection(dbAddress,nomeUtente,password);
		PreparedStatement statement=connection.prepareStatement(query);
		
		statement.setString(1, habitat);
				
				
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			Animale d=new Animale(result.getInt("id"),result.getString("nome"),result.getString("razza"),result.getString("ddn"),result.getBoolean("carnivoro"),result.getInt("idgabbia"));
			animali.add(d);
		}

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return animali;
		
	}
	
	
	@Override
	public List<Animale> listaAnimali(String habitat) {
		return listaAnimaliConnection("SELECT animali.* FROM animali inner join gabbie on gabbie.id=animali.idgabbia WHERE gabbie.tipoabitat=?",habitat);
	}

}
