package com.packsendme.roadway.shippingsheduling.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.packsendme.lib.roadway.simulation.response.SimulationRoadwayResponse;

@Repository
public interface IShippingsheduling_Repository extends MongoRepository<SimulationRoadwayResponse, String>{

}

