package it.polito.tdp.rivers.db;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.rivers.model.River;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RiversDAO {

	public void getAllRivers(Map<Integer, River> idMap) {
		
		final String sql = "SELECT id, name FROM river";

		//List<River> rivers = new LinkedList<River>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				if(!idMap.containsKey(res.getInt("id"))) {
					River r= new River(res.getInt("id"), res.getString("name"));
					idMap.put(r.getId(), r);
				}
				
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		
	}
	
	/**
	 * Dato un {@code River}, ottiene le informazioni circa la prima misurazione, 
	 * l'ultima misurazione, il numero totale di misurazioni ed un valore medio
	 * @param r {@code River} da analizzare
	 * @return 
	 */
	public River infoRiver(River r) {
		
		String sql= "SELECT NAME, count(flow) AS n, AVG(flow) AS fmed, MIN(DAY) AS min, MAX(DAY)AS max " + 
				"FROM flow, river " + 
				"WHERE flow.river=river.id AND NAME=? " + 
				"GROUP BY NAME "; 
		River river=null; 
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,  r.getName());
			ResultSet res = st.executeQuery();

			if (res.next()) {
				river= new River(r.getId(), r.getName(), res.getDouble("fmed"), 
						res.getString("min"), res.getString("max"), res.getInt("n")); 
				
			}

			conn.close();
			return river; 
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}
		
	}
}
