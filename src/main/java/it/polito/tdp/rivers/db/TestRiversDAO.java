package it.polito.tdp.rivers.db;

import it.polito.tdp.rivers.model.River;

public class TestRiversDAO {

	public static void main(String[] args) {
		RiversDAO dao = new RiversDAO();
		//System.out.println(dao.getAllRivers());
		
		River r= dao.infoRiver(new River(4,"Oldman Rivernear Brocket"));
		System.out.println(r.getPrimaMisurazione()); 
	}

}
