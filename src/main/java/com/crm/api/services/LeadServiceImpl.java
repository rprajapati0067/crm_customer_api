package com.crm.api.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.api.domain.Lead;
import com.crm.api.domain.MarkLeadRequest;
import com.crm.api.exceptions.RecordNotFoundException;
import com.crm.api.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {
	@Autowired
	private LeadRepository repository;

	public Lead save(Lead lead) {
		Lead l = new Lead();
		Lead savedData = repository.save(lead);

		if (savedData != null) {

			l.setFirstName("");
			l.setLastName("");
			l.setMobile("");
			l.setEmail("");
			l.setLocationType("");
			l.setLocationString("");
			l.setStatus("Created");
		}

		return l;

	}

	public Lead findById(Integer id) throws RecordNotFoundException {

		Optional<Lead> lead = repository.findById(id);

		if (lead.isPresent()) {
			return lead.get();
		} else {
			// return new Lead();
			throw new RecordNotFoundException("No Lead record exist for given id");
		}

	}

	public List<Lead> findAll() {
		List<Lead> leadList = new ArrayList<>();
		repository.findAll().forEach(leadList::add);

		return leadList;

	}

	public void removeById(Integer id) throws RecordNotFoundException {

		Optional<Lead> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No Lead record exist for given id");
		}

	}

	public Lead updateById(Integer id, Lead lead) {
		Optional<Lead> leadId = repository.findById(id);

		if (leadId.isPresent()) {
			Lead newEntity = leadId.get();
			newEntity.setFirstName(lead.getFirstName());
			newEntity.setLastName(lead.getLastName());
			newEntity.setMobile(lead.getMobile());
			newEntity.setEmail(lead.getEmail());
			newEntity.setLocationType(lead.getLocationType());
			newEntity.setLocationString(lead.getLocationString());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			lead = repository.save(lead);

			return lead;
		}

	}

	public Lead markLead(Integer id, MarkLeadRequest lead) throws RecordNotFoundException {
		Optional<Lead> leadId = repository.findById(id);

		if (leadId.isPresent()) {
			Lead newEntity = leadId.get();
			newEntity.setStatus("contacted");
			newEntity.setCommunication(lead.getCommunication());
			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			throw new RecordNotFoundException("No Lead record exist for given id");
		}

	}

}
