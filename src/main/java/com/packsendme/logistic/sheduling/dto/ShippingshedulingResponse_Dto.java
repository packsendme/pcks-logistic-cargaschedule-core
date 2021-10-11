package com.packsendme.logistic.sheduling.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.packsendme.lib.roadway.simulation.response.SimulationRoadwayResponse;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class ShippingshedulingResponse_Dto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<SimulationRoadwayResponse> simulationResponseL = new ArrayList<SimulationRoadwayResponse>();

	public ShippingshedulingResponse_Dto(List<SimulationRoadwayResponse> simulationResponseL) {
		super();
		this.simulationResponseL = simulationResponseL;
	}


	
	
}
