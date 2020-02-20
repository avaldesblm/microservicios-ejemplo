package com.microservices.example.app.telcel0.models.service;

import java.util.List;

import com.microservices.example.app.telcel0.models.entity.transaction;

public interface ITrxService {
	
	public transaction save(transaction trx);
	
	public List<transaction> findAll(); 
	public transaction findById(Long id);
	
}
