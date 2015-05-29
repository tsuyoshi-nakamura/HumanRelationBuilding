package jp.co.seattleconsulting.HumanRelationBuilding.util;

import jp.co.seattleconsulting.HumanRelationBuilding.dto.IndexDto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson {

	public String toJson(IndexDto dto) throws Exception {
		IndexDto indexDto = dto;

		ObjectMapper jsonMapper = new ObjectMapper();

		String json = jsonMapper.writeValueAsString(indexDto);

		return json;
	}

}

