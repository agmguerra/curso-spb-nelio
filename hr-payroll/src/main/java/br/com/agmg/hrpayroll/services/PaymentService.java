package br.com.agmg.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.agmg.hrpayroll.entities.Payment;
import br.com.agmg.hrpayroll.entities.Worker;
import br.com.agmg.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	//private String workerHost;
	
	//Vamos substituto pelo uso do Feign
	//private RestTemplate restTemplate;
	
	private WorkerFeignClient workerFeignClient;
	
	public PaymentService(WorkerFeignClient workerFeignClient) {
		this.workerFeignClient = workerFeignClient;
	}
	
	public Payment getPayment(Long workerId, int days) {
		
		//Map <String, String> uriVariables = new HashMap<>();
		//uriVariables.put("id", String.valueOf(workerId));
		
		//Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
			
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}

}
