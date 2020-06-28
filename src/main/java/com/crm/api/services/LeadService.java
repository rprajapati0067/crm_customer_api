package com.crm.api.services;

import java.util.List;

import com.crm.api.domain.Lead;
import com.crm.api.domain.MarkLeadRequest;
import com.crm.api.exceptions.RecordNotFoundException;

public interface LeadService {
	Lead save(Lead lead);

	Lead findById(Integer id) throws RecordNotFoundException;

	void removeById(Integer id) throws RecordNotFoundException;

	Lead updateById(Integer id, Lead lead);

	List<Lead> findAll();
	
	Lead markLead(Integer id, MarkLeadRequest lead) throws RecordNotFoundException;
}
