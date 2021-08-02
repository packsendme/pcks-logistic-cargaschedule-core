package com.packsendme.roadway.shippingsheduling.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.packsendme.lib.common.constants.generic.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.lib.roadway.simulation.request.SimulationRoadwayRequest;
import com.packsendme.lib.roadway.simulation.request.SimulationRoadwayRequest_Dto;
import com.packsendme.lib.roadway.simulation.response.SimulationRoadwayResponse;
import com.packsendme.lib.roadwaycalculate.rulesinstance.InstanceRuleCosts;
import com.packsendme.roadway.shippingsheduling.component.LoadDataFacadeImpl;
import com.packsendme.roadway.shippingsheduling.dao.SimulationDBImpl_Dao;
import com.packsendme.roadway.shippingsheduling.dto.ShippingshedulingResponse_Dto;

@Service
@ComponentScan("com.packsendme.roadway.simulation.component")
public class Shippingsheduling_Service {
	
	@Autowired(required=true)
	private LoadDataFacadeImpl roadwayLoadData;
	
	@Autowired(required=true)
	private SimulationDBImpl_Dao simulationDAO;

	
	public ResponseEntity<?> getSimulationTransport(SimulationRoadwayRequest simulationDataObj, Map header) {
		Response<SimulationRoadwayResponse> responseObj = null;
		try {
			// Load Data From API or Cache
			SimulationRoadwayRequest_Dto simulationDataDto_Obj = roadwayLoadData.getData(simulationDataObj, header);
			InstanceRuleCosts instanceRulesObj = new  InstanceRuleCosts();
			
			// Instance JAR - Costs Calculate 
			SimulationRoadwayResponse simulationRoadwayResp = instanceRulesObj.instanceRulesCosts(simulationDataDto_Obj);
			
			responseObj = new Response<SimulationRoadwayResponse>(0,HttpExceptionPackSend.SIMULATION_ROADWAY.getAction(), simulationRoadwayResp);
			return new ResponseEntity<>(responseObj, HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			responseObj = new Response<SimulationRoadwayResponse>(0,HttpExceptionPackSend.SIMULATION_ROADWAY.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<?> postSimulationResponse(SimulationRoadwayResponse entity) {
		Response<SimulationRoadwayResponse> responseObj = null;
		try {
			// Save SimulationDAO
			simulationDAO.save(entity);
			responseObj = new Response<SimulationRoadwayResponse>(0,HttpExceptionPackSend.SIMULATION_ROADWAY.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			responseObj = new Response<SimulationRoadwayResponse>(0,HttpExceptionPackSend.SIMULATION_ROADWAY.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<?> getSimulation() {
		Response<ShippingshedulingResponse_Dto> responseObj = null;
		try {
			// Save SimulationDAO
			List<SimulationRoadwayResponse> simulationL = simulationDAO.findAll();
			ShippingshedulingResponse_Dto simulationResponse = new ShippingshedulingResponse_Dto(simulationL);
			responseObj = new Response<ShippingshedulingResponse_Dto>(0,HttpExceptionPackSend.SIMULATION_ROADWAY.getAction(), simulationResponse);
			return new ResponseEntity<>(responseObj, HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			responseObj = new Response<ShippingshedulingResponse_Dto>(0,HttpExceptionPackSend.SIMULATION_ROADWAY.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<?> deleteSimulation(String id) {
		Response<SimulationRoadwayResponse> responseObj = null;
		try {
			// Delete Simulation
			simulationDAO.delete(id);
			responseObj = new Response<SimulationRoadwayResponse>(0,HttpExceptionPackSend.SIMULATION_ROADWAY.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			responseObj = new Response<SimulationRoadwayResponse>(0,HttpExceptionPackSend.SIMULATION_ROADWAY.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.BAD_REQUEST);
		}
	}

	
	
}
