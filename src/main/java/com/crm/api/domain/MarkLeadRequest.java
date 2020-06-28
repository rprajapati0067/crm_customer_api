package com.crm.api.domain;

import javax.validation.constraints.NotEmpty;

public class MarkLeadRequest {

	private String status;

	@NotEmpty(message = "communication is required")
	private String communication;
	
	
	public MarkLeadRequest() {
		// TODO Auto-generated constructor stub
	}

	public MarkLeadRequest(String status, @NotEmpty(message = "communication is required") String communication) {
		super();
		this.status = status;
		this.communication = communication;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCommunication() {
		return communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	@Override
	public String toString() {
		return "MarkLeadRequest [status=" + status + ", communication=" + communication + "]";
	}

}
