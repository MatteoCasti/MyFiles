package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Stato;

public class Dao implements Idao {
	
	private String dbAddress;
	private String utente;
	private String password;
	
	
	
	public Dao(String dbAddress, String utente, String password) {
		super();
		this.dbAddress = dbAddress;
		this.utente = utente;
		this.password = password;
	}
	
	

	@Override
	public String toString() {
		return "Dao [dbAddress=" + dbAddress + ", utente=" + utente + ", password=" + password + "]";
	}
	
	
	private void closeConnection(Connection con) throws SQLException {
		if (!con.isClosed()) {
					con.close();
				}
	}
	
	private PreparedStatement creaStatement(Connection con, String query) throws SQLException {

		con=DriverManager.getConnection(dbAddress,utente,password);
		return con.prepareStatement(query);
	}
	
	
	private List<Stato> listaStatiConnessione(String query){
		Connection connection=null;
		ArrayList<Stato> stati=new ArrayList<>();
		try {
			
		connection=DriverManager.getConnection(dbAddress,utente,password);
		//PreparedStatement statement=creaStatement(connection,query);
		PreparedStatement statement=connection.prepareStatement(query);
			
				
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			Stato d=new Stato(result.getInt("id"),result.getString("nome"),result.getInt("popolazione"),result.getString("moneta"),result.getString("religioneufficiale"));
			stati.add(d);
		}

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stati;
	}

	@Override
	public List<Stato> listaStati() {
		
		return listaStatiConnessione("SELECT * FROM stati");
		
	}
	
	
	private void aggiungiStatoConnection(String query,Stato s) {
		Connection connection=null;
		
		try {
			
		connection=DriverManager.getConnection(dbAddress,utente,password);
		//PreparedStatement statement=creaStatement(connection,query);
		PreparedStatement statement=connection.prepareStatement(query);
		
		
		statement.setString(1, s.getNome());
		statement.setInt(2, s.getPopolazione());
		statement.setString(3, s.getMoneta());
		statement.setString(4, s.getReligioneufficiale());
		statement.executeQuery();
		

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void aggiungiStato(Stato s) {
		
		aggiungiStatoConnection("INSERT INTO stati (nome, popolazione,moneta,religioneufficiale) values (?,?,?,?)", s);
	}

	
	private void updateStatoConnection(String query,Stato s,int idStato) {
	Connection connection=null;
		
		try {
			
		connection=DriverManager.getConnection(dbAddress,utente,password);
		//PreparedStatement statement=creaStatement(connection,query);
		PreparedStatement statement=connection.prepareStatement(query);
		
		
		statement.setString(1, s.getNome());
		statement.setInt(2, s.getPopolazione());
		statement.setString(3, s.getMoneta());
		statement.setString(4, s.getReligioneufficiale());
		statement.setInt(5, idStato);
		statement.executeQuery();
		

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void updateStato(Stato s, int idStato) {
		
		updateStatoConnection("UPDATE stati SET nome=?,popolazione=?,moneta=?,religioneufficiale=? WHERE id=?",s,idStato);
		
	}
	
	private void aggiungiConfineConnection(String query,int idStato1,int idStato2, int lConfine) {
	Connection connection=null;
		
		try {
			
		connection=DriverManager.getConnection(dbAddress,utente,password);
		//PreparedStatement statement=creaStatement(connection,query);
		PreparedStatement statement=connection.prepareStatement(query);
		
		
		statement.setInt(1, idStato1);
		statement.setInt(2, idStato2);
		statement.setInt(3, lConfine);
		
		
		statement.executeQuery();
		

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private void  aggiungiConfine(int idStato1,int idStato2, int lConfine) {
		aggiungiConfineConnection("INSERT INTO confini (idstato1,idstato2,lunghezza ) values (?,?,?)",idStato1,idStato2,lConfine);
	}

	@Override
	public void aggiungiStato(Stato s, int idStato, int lConfine) {
		updateStato(s,s.getId());
		aggiungiConfine(s.getId(),idStato,lConfine);
		
	}
	
	private void eliminaConfineConnection(String query,int idStato) {
	Connection connection=null;
		
		try {
			
		connection=DriverManager.getConnection(dbAddress,utente,password);
		//PreparedStatement statement=creaStatement(connection,query);
		PreparedStatement statement=connection.prepareStatement(query);
		
		
		
	
		statement.setInt(1, idStato);
		statement.setInt(2, idStato);
		statement.executeQuery();
		

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private void eliminaConfine(int idStato) {
		eliminaConfineConnection("DELETE FROM confini WHERE idstato1= ? OR idstato2=?",idStato);
	}

	private void deleteStatoConnection(String query,int idStato) {
	Connection connection=null;
		
		try {
			
		connection=DriverManager.getConnection(dbAddress,utente,password);
		//PreparedStatement statement=creaStatement(connection,query);
		
		eliminaConfine(idStato);
		PreparedStatement statement=connection.prepareStatement(query);
		
		
		
		statement.setInt(1, idStato);
	
		statement.executeQuery();
		

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void deleteStato(int idStato) {
		deleteStatoConnection("DELETE FROM stati WHERE id =?",idStato);
		
	}

	private Map<String,Integer> confineLungoConnection(String query,int idStato){
		Connection connection=null;
		HashMap<String,Integer> stato=new HashMap<>();
		try {
			
		connection=DriverManager.getConnection(dbAddress,utente,password);
		//PreparedStatement statement=creaStatement(connection,query);
		
		
		PreparedStatement statement=connection.prepareStatement(query);
		
		
		
		statement.setInt(1, idStato);
	
		ResultSet rs=statement.executeQuery();
		stato.put(rs.getString("nome"), rs.getInt("confine"));

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stato;
	}
	
	@Override
	public Map<String,Integer> confineLungo(int idStato) {
		return confineLungoConnection("select stati2.nome as nome, max(lunghezza) as confine "
				+ "from stati  inner join confini on stati.id=confini.idstato1 "
				+ "inner join stati as stati2 on confini.idstato2=stati2.id "
				+ "where stati.id =? "
				+ "group by stati.id",idStato);
	}

	
	private List<Stato> religioneDiversaRispettoConnection(String query, int idStato){
		Connection connection=null;
		ArrayList<Stato> stati=new ArrayList<>();
		try {
			
		connection=DriverManager.getConnection(dbAddress,utente,password);
		//PreparedStatement statement=creaStatement(connection,query);
		PreparedStatement statement=connection.prepareStatement(query);
			
		statement.setInt(1, idStato);
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			Stato d=new Stato(result.getInt("id"),result.getString("nome"),result.getInt("popolazione"),result.getString("moneta"),result.getString("religioneufficiale"));
			stati.add(d);
		}

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stati;
	}
	@Override
	public List<Stato> religioneDiversaRispetto(int idStato) {
		return religioneDiversaRispettoConnection("select * from stati where religioneufficiale!=(select religioneufficiale from stati where stati.id=1)",idStato);
	}

	private int popolazioneStato(String query,int idStato) {
		int popolazione=0;
		Connection connection=null;
		
		try {
			
		connection=DriverManager.getConnection(dbAddress,utente,password);
		//PreparedStatement statement=creaStatement(connection,query);
		PreparedStatement statement=connection.prepareStatement(query);
			
		statement.setInt(1, idStato);
		ResultSet result=statement.executeQuery();
		popolazione=result.getInt(popolazione);
		

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return popolazione;
	}
	private int popolazioneStatiConfinanti(String query,int idStato) {
		int popolazione=0;
		Connection connection=null;
		
		try {
			
		connection=DriverManager.getConnection(dbAddress,utente,password);
		//PreparedStatement statement=creaStatement(connection,query);
		PreparedStatement statement=connection.prepareStatement(query);
			
		statement.setInt(1,idStato);
		ResultSet result=statement.executeQuery();
		popolazione=result.getInt("conteggio");
		

		
		
		} catch (SQLException e) {
		System.out.println("OPS, questo è imbarazzante. Abbiamo perso la connessione!!!!");
		e.printStackTrace();
		}finally {
			try {
				closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return popolazione;
	}
	
	private int popolazioneTotaleConnection(int idStato ) {
	
		return popolazioneStato("SELECT popolazione FROM stati WHERE id=?",idStato)+popolazioneStatiConfinanti("select sum(stati.popolazione) as conteggio "
				+ "from confini inner join stati on confini.idstato2=stati.id "
				+ "where confini.idstato1=? "
				+ "group by confini.idstato1",idStato);
	}
	
	@Override
	public int popolazioneTotale(int idStato) {
		return popolazioneTotaleConnection(idStato);
	}

}
