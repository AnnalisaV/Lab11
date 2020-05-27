package it.polito.tdp.rivers.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.rivers.db.RiversDAO;


public class Model {

	private Map<Integer, River> idMapRiver; 
	private RiversDAO dao; 
 
	
	
	public Model() {
		this.idMapRiver= new HashMap<>(); 
		this.dao= new RiversDAO(); 
		dao.getAllRivers(idMapRiver);
		
	}
	
	public Collection<River> getRivers(){
		return this.idMapRiver.values(); 
	}
	
	

	/**
	 * Informazioni circa un particolare {@code River}
	 * @param r {@code River} di cui si vogliono le info
	 * @return {@code River} con le info corrette 
	 */
	public River info(River r) {
		return dao.infoRiver(r); 
	}
	

}


