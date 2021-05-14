package br.com.agmg.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.agmg.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(Long workerId, int days) {
		
		//Mock para implementacao inicial
		return new Payment("Bob", 200.0, days);
		
	}

}
