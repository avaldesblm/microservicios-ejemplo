package com.microservices.example.app.telcel0.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.example.app.telcel0.models.entity.transaction;
import com.microservices.example.app.telcel0.models.service.ITrxService;

@RestController //Convertir a json lo que regresa el método handler
public class trxController {
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private ITrxService trxService;
	
	@PostMapping("/telcelTrx")
	@ResponseStatus(HttpStatus.CREATED)
	public transaction newTelcelTrx(@RequestBody transaction trx) throws Exception {
		return trxService.save(trx);
	}
	
	@GetMapping("/getTransactions")
	public List<transaction> getTrx(){
		/*
		return trxService.findAll().stream().map(p ->{
			p.setPort(port);
			return p;
		}).collect(Collectors.toList());
		*/
		return trxService.findAll();
	}
	
	@GetMapping("/getTrx/{id}")
	public transaction getTrxById(@PathVariable Long id) throws Exception{
		transaction trx = trxService.findById(id);
		/*
		if(true) {
			throw new Exception("No se pudo cargar el producto");
		}
		*/
		
		/*
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		return trx;
		
	}
	
}
