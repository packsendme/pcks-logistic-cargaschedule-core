package com.packsendme.logistic.cargashedule.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.packsendme.cross.common.dto.logistic.AvailableManifest_Dto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class AvailableManifestResponse_Dto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<AvailableManifest_Dto> availableManifestResponseL = new ArrayList<AvailableManifest_Dto>();

	public AvailableManifestResponse_Dto(List<AvailableManifest_Dto> availableManifestResponseL) {
		super();
		this.availableManifestResponseL = availableManifestResponseL;
	}
}
