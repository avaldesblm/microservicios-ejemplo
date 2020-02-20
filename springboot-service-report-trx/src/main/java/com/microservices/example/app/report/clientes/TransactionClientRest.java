package com.microservices.example.app.report.clientes;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.example.app.report.models.transaction;

@FeignClient(name="servicio-telcel0")
public interface TransactionClientRest {
	
	@GetMapping("/getTransactions")
	public List<transaction> getTransactions();
	
	@GetMapping("/getTrx/{id}")
	public transaction getTrxById(@PathVariable Long id);
	
	@PostMapping("/telcelTrx")
	public transaction telcelTrx(@RequestBody transaction trx);

}
