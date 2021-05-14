package br.com.agmg.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agmg.hrworker.entities.Worker;
import br.com.agmg.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private static Logger logger =LoggerFactory.getLogger(WorkerResource.class);
	
	private Environment env;
	
	private WorkerRepository repository;

	public WorkerResource(WorkerRepository repository, Environment env) {
		this.env = env;
		this.repository = repository;
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		
		List<Worker> list = repository.findAll();
		
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		
		logger.info("FIND ALL ON SERVER PORT = " + env.getProperty("local.server.port"));
		
		Worker worker = repository.findById(id).get();
		
		return ResponseEntity.ok(worker);
		
	}
	
}
