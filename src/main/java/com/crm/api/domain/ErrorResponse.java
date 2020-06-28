package com.crm.api.domain;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private String status;
	private HttpStatus code;
	private String reason;

	public ErrorResponse() {

	}

	

	public ErrorResponse(String status, HttpStatus code, String reason) {
		super();
		this.status = status;
		this.code = code;
		this.reason = reason;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "ErrorResponse [status=" + status + ", code=" + code + ", reason=" + reason + "]";
	}

}
