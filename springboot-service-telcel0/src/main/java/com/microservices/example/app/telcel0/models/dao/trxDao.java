package com.microservices.example.app.telcel0.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.microservices.example.app.telcel0.models.entity.transaction;

public interface trxDao extends CrudRepository<transaction, Long>{

}
