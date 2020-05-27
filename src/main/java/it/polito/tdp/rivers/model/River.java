package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class River {
	private int id;
	private String name;
	private double flowAvg;
	private List<Flow> flows;
	
	private String primaMisurazione; 
	private String ultimaMisurazione; 
	private int misurazioniTot; 
	
	
	/**
	 * @param id
	 * @param name
	 * @param flowAvg
	 * @param flows
	 * @param primaMisurazione
	 * @param ultimaMisurazione
	 * @param misurazioniTot
	 */
	public River(int id, String name, double flowAvg, String primaMisurazione,
			String ultimaMisurazione, int misurazioniTot) {
		super();
		this.id = id;
		this.name = name;
		this.flowAvg = flowAvg;
		this.primaMisurazione = primaMisurazione;
		this.ultimaMisurazione = ultimaMisurazione;
		this.misurazioniTot = misurazioniTot;
	}

	public River(int id) {
		this.id = id;
	}

	public River(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getFlowAvg() {
		return flowAvg;
	}

	public void setFlowAvg(double flowAvg) {
		this.flowAvg = flowAvg;
	}

	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}

	public List<Flow> getFlows() {
		if (flows == null)
			flows = new ArrayList<Flow>();
		return flows;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		River other = (River) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getPrimaMisurazione() {
		return primaMisurazione;
	}

	public String getUltimaMisurazione() {
		return ultimaMisurazione;
	}

	public int getMisurazioniTot() {
		return misurazioniTot;
	}
	
	
	
}
