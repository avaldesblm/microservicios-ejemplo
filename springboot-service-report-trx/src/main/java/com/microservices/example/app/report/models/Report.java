package com.microservices.example.app.report.models;

public class Report {
	
	public Report() {
	}
	
	public Report(transaction trx) {
		this.trx = trx;
	}
	
	private transaction trx;
	
	public transaction getTrx() {
		return trx;
	}
	public void setTrx(transaction trx) {
		this.trx = trx;
	}
	
	public int getComission() {
		Double amount = trx.getAmount();
		if(amount == 0) {
			return 0;
		} else if(amount > 0 && amount <= 200) {
			return 6;
		} else {
			return 5;
		}
		/*
		if(trx.getAmount() <= 200) {
			return 6;
		} else {
			return 5;
		}
		*/
	}

}
