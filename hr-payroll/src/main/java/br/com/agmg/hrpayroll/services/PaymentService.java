package br.com.agmg.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.agmg.hrpayroll.entities.Payment;
import br.com.agmg.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	private String workerHost;
	
	private RestTemplate restTemplate;
	
	public PaymentService(RestTemplate restTemplate, @Value("${hr-worker.host}") String workerHost) {
		this.workerHost = workerHost;
		this.restTemplate = restTemplate;
	}
	
	public Payment getPayment(Long workerId, int days) {
		
		Map <String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
			
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}

}
