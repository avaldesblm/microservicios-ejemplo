package com.microservices.example.app.telcel0.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.example.app.telcel0.models.dao.trxDao;
import com.microservices.example.app.telcel0.models.entity.transaction;

@Service
public class ITrxServiceImpl implements ITrxService{
	
	@Autowired
	private trxDao trxDao;

	@Override
	@Transactional()
	public transaction save(transaction trx) {
		return trxDao.save(trx);
	}

	@Override
	@Transactional(readOnly = true)
	public List<transaction> findAll() {
		return (List<transaction>) trxDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public transaction findById(Long id) {
		return trxDao.findById(id).orElse(null);
	}

}
