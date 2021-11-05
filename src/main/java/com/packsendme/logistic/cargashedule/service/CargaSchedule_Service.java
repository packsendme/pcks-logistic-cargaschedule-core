package com.packsendme.logistic.cargashedule.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.packsendme.cross.common.constants.generic.HttpExceptionPackSend;
import com.packsendme.cross.common.dto.logistic.LogisticManifest_Dto;
import com.packsendme.cross.common.response.Response;
import com.packsendme.logistic.cargashedule.component.LoadDataFacadeImpl;
import com.packsendme.logistic.cargashedule.dao.SimulationDBImpl_Dao;

@Service
@ComponentScan("com.packsendme.roadway.simulation.component")
public class CargaSchedule_Service {
	
	@Autowired(required=true)
	private LoadDataFacadeImpl roadwayLoadData;
	
	@Autowired(required=true)
	private SimulationDBImpl_Dao simulationDAO;

	
	public ResponseEntity<?> createLogisticManifest(LogisticManifest_Dto logisticManifest, Map header) {
		Response<LogisticManifest_Dto> responseObj = null;
		try {
			
			responseObj = new Response<LogisticManifest_Dto>(0,HttpExceptionPackSend.CREATED.getAction(), logisticManifest);
			return new ResponseEntity<>(responseObj, HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			responseObj = new Response<LogisticManifest_Dto>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
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
