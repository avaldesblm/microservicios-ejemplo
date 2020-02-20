package com.microservices.example.app.report.models.service;

import java.util.List;

import com.microservices.example.app.report.models.Report;
import com.microservices.example.app.report.models.transaction;

public interface ReportService {
	
	public List<Report> findAll();
	public Report findById(Long id);
	public transaction save(transaction trx);
	
}
