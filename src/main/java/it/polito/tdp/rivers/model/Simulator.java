package it.polito.tdp.rivers.model;

public class Simulator {

	
	//PARAMETRI SIMULAZIONE
	private double Q; //capienza totale del bacino in m^3
	
	public void setQ(int k) {
		Double fMedio=this.r.getFlowAvg()*3600;  //impostato al giorno 
		this.Q= k*fMedio*30; 
	}
	
	//MONDO
	River r; //il fiume di riferimento
	private double c; //quantita' acqua nel bacino
	
	
	//OUTPUT
	private int giorniNo; //non e' stata garantita l'erogazione minima
	private double cMedio; 
	
	
	/**
	 * Fase di inizializzazione della simulazione 
	 */
	public void init(int k, River r) {
		this.setQ(k);
		
		this.c= this.Q/2; 
		
		this.giorniNo=0; 
		
		
		
	}
	
	
}
