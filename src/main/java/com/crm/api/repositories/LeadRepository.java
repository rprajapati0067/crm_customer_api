package com.crm.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.crm.api.domain.Lead;

public interface LeadRepository extends CrudRepository<Lead, Integer>{

}
