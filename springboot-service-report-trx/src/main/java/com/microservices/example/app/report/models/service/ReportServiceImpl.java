package com.microservices.example.app.report.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.microservices.example.app.report.models.Report;
import com.microservices.example.app.report.models.transaction;

/*
 * Class implemented with rest template 
*/
@Service("serviceRestTemplate")
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Report> findAll() {
		List<transaction> trxList = Arrays.asList(clienteRest.getForObject("http://servicio-telcel0/getTransactions", transaction[].class));
		return trxList.stream()
				.map(p -> new Report(p))
				.collect(Collectors.toList());
	}

	@Override
	public Report findById(Long id) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		transaction trx = clienteRest.getForObject("http://servicio-telcel0/getTrx/{id}", transaction.class, pathVariables);
		return new Report(trx);
	}
	
	@Override
	public transaction save(transaction trx) {
		HttpEntity<transaction> body = new HttpEntity<transaction> (trx);
		ResponseEntity<transaction> response =  clienteRest.exchange("http://servicio-telcel0/telcelTrx", HttpMethod.POST, body, transaction.class);
		transaction productoResponse = response.getBody();
		return productoResponse;
	}

}
