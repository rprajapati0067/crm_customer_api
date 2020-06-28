package com.crm.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crm.api.domain.Lead;
import com.crm.api.domain.MarkLeadRequest;
import com.crm.api.exceptions.RecordNotFoundException;
import com.crm.api.services.LeadService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LeadController {
	@Autowired
	private LeadService service;

	@GetMapping("/ping")
	public String ping() {
		return "Pong";
	}

	@GetMapping("/api/leads")
	public ResponseEntity<List<Lead>> getAll(@RequestParam String location_string) throws RecordNotFoundException {

		return new ResponseEntity<List<Lead>>(service.findAll(), new HttpHeaders(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/api/leads")
	public ResponseEntity<Lead> create(@RequestBody @Valid Lead lead) throws RecordNotFoundException {

		return new ResponseEntity<Lead>(service.save(lead), new HttpHeaders(), HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@PutMapping("/api/leads/{lead_id}")
	public ResponseEntity<Lead> update(@PathVariable(value = "lead_id") Integer leadId, @RequestBody @Valid Lead lead) {

		return new ResponseEntity<Lead>(service.updateById(leadId, lead), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@PutMapping("/api/mark_lead/{lead_id}")
	public ResponseEntity<MarkLeadRequest> markLead(@PathVariable(value = "lead_id") Integer leadId,
			@RequestBody @Valid MarkLeadRequest leadRequest) throws RecordNotFoundException {

		Lead leadData = service.markLead(leadId, leadRequest);
		MarkLeadRequest mr = new MarkLeadRequest(leadData.getStatus(), leadData.getCommunication());
		return new ResponseEntity<MarkLeadRequest>(mr, HttpStatus.ACCEPTED);

	}

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/api/leads/{lead_id}")
	public ResponseEntity<Lead> get(@PathVariable(value = "lead_id") Integer leadId) throws RecordNotFoundException {

		return new ResponseEntity<Lead>(service.findById(leadId), new HttpHeaders(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@DeleteMapping("/api/leads/{lead_id}")
	public ResponseEntity<Map<String, String>> remove(@PathVariable(value = "lead_id") Integer leadId)
			throws RecordNotFoundException {
		service.removeById(leadId);
		Map<String, String> map = new HashMap<>();
		map.put("status", "success");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
}
