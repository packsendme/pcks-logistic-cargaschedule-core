package com.packsendme.logistic.cargashedule.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.packsendme.cross.common.dto.logistic.LogisticManifest_Dto;
import com.packsendme.logistic.cargashedule.service.CargaSchedule_Service;


@RestController
@RequestMapping("/logistic/cargasheduling")
public class CargaScheduleController {

	@Autowired
	private CargaSchedule_Service cargaScheduleService;

	private Map<String, String> header = new HashMap<String, String>();
	
	
	// ========= LOGISTIC MANIFEST  =========================================// 
    
	// STATUS: LOGISTIC NO SHARE
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/logisticmanifest")
	public ResponseEntity<?> postLogisticManifest(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated @RequestBody LogisticManifest_Dto logisticManifest)
		throws JsonProcessingException, IOException 
	{	
		header.put("isoLanguageCode", isoLanguageCode);
		header.put("isoCountryCode", isoCountryCode);
		header.put("isoCurrencyCode", isoCurrencyCode);
		header.put("originApp", originApp);
		
		return cargaScheduleService.createLogisticManifest(logisticManifest,header);
	}
	
	
//========= AVAILABLE MANIFEST =========================================// 
	
	// STATUS: LOGISTIC SHARE
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/availablemanifest/{idAvailableManifest}")
	public ResponseEntity<?> postAvailableManifest(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@RequestParam("idAvailableManifest") String idAvailableManifest,
			@Validated @RequestBody LogisticManifest_Dto logisticManifest)
		throws JsonProcessingException, IOException 
	{	
		header.put("isoLanguageCode", isoLanguageCode);
		header.put("isoCountryCode", isoCountryCode);
		header.put("isoCurrencyCode", isoCurrencyCode);
		header.put("originApp", originApp);
		
		return roadwayService.postAvailableManifest(logisticManifest);
	}

	
	
	
	// METHOD INSTANCE FOR SIMULATION_MICROSERVICES
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/availablemanifest/{city_origin}/{city_destination}/{weight_cargo}/"
			+ "{unityWeight}/{height_cargo}/{width_cargo}/{length_cargo}")
	public ResponseEntity<?> getAvailableManifest(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@RequestParam("city_origin") String city_origin,
			@RequestParam("city_destination") String city_destination,
			@RequestParam("weight_cargo") double weight_cargo,
			@RequestParam("unityWeight") String weight_unity,
			@RequestParam("height_cargo") String height_cargo,
			@RequestParam("width_cargo") String width_cargo,
			@RequestParam("length_cargo") String length_cargo)
		throws JsonProcessingException, IOException 
	{	
		header.put("isoLanguageCode", isoLanguageCode);
		header.put("isoCountryCode", isoCountryCode);
		header.put("isoCurrencyCode", isoCurrencyCode);
		header.put("originApp", originApp);
		
		return roadwayService.getAvailableManifest(logisticManifest);
	}
	
		
	

}
