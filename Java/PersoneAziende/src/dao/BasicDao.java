package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BasicDao {

private Connection connection;
	
	public BasicDao(String dbAddress, String user, String password) {
		try {
			connection = DriverManager.getConnection(dbAddress, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Le righe derivanti dalla query inviata al database saranno in formato
	// "generico" Map<String, String>
	// Ogni mappa contiene le informazioni di una riga derivante dalla query
	// ... ? questo viene chiamato spread operator
	// Significa che questo metodo per essere invocato accetta da 0 a infiniti parametri
	// al posto di conditions
	// Si comporta come un vettore di Object
	// Perché Object come parametri? Perché tutto può essere un oggetto
	/**
	 * Lista contenente le mappe che descrivono le entità nella persistenza.
	 * La mappa è la rappresentazione di una RIGA di una tabella.
	 * La lista quindi è l'insieme delle righe di una tabella
	 * @param sql la qeury da inviare al DB
	 * @param conditions il/i valore/i (opzionali) da sostituire ai placeholders
	 * della query
	 * @return La lista contenente tutte le mappe restituire dal db in base alla query
	 */
	public List<Map<String, String>> getAll(String sql, Object... conditions) {
		List<Map<String, String>> ris = new ArrayList<>();
		
		try {
			// Richiedo alla connessione (aperta alla creazione dell'oggetto)
			// il preparedstatement passandogli la query che arriva da parametro
			// La query può arrivare in questa maniera:
			// SELECT * FROM tabella
			// SELECT * FROM tabella WHERE colonna IN (?, ?)
			
//			PreparedStatement stm = connection.prepareStatement(sql);
//			
//			for (int i = 1; i <= conditions.length; i++) {
//				// i ? hanno un indice incrementale che parte da 1
//				// i vettori invece da 0
//				// setObject funziona in tutti i casi: string, int, boolean, ...
//				stm.setObject(i, conditions[i - 1]);
//			}
			
			ResultSet rs = executeQuery(sql, conditions);
			
			while (rs.next()) {
				ris.add(mapFromRs(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ris;
	}

	private Map<String, String> mapFromRs(ResultSet rs) throws SQLException {
		Map<String, String> map = new HashMap<>();
		
		ResultSetMetaData meta = rs.getMetaData();
		
		for (int i = 1; i <= meta.getColumnCount(); i++) {
			map.put(meta.getColumnName(i), rs.getString(i));
		}
		
		return map;
	}
	
	private ResultSet executeQuery(String sql, Object... conditions) throws SQLException {
		return preparedStatement(sql, conditions).executeQuery();
	}
	
	private PreparedStatement preparedStatement(String sql, Object...conditions) throws SQLException {
		PreparedStatement stm = connection.prepareStatement(sql);
		
		for (int i = 0; i < conditions.length; i++) {
			// i ? hanno un indice incrementale che parte da 1
			// i vettori invece da 0
			// setObject funziona in tutti i casi: string, int, boolean, ...
			stm.setObject(i + 1, conditions[i]);
		}
		
		return stm;
	}
	
	public Map<String, String> getOne(String sql, Object... conditions) {
		Map<String, String> ris = null;
		
		try {
			ResultSet rs = executeQuery(sql, conditions);
			
			if (rs.next()) {
				ris = mapFromRs(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ris;
	}
	
	public void execute(String sql, Object... conditions) {
		try {
			preparedStatement(sql, conditions).execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
