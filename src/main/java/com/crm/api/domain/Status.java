package com.crm.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

enum Status {
	@JsonProperty("created")
	CREATED, @JsonProperty("contacted")
	CONTACTED;
}
