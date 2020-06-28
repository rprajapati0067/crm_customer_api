package com.crm.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

enum LocationType {
	@JsonProperty("country")
	COUNTRY, 
	@JsonProperty("city")
	CITY,
	@JsonProperty("zip")
	ZIP;
}
