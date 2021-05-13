package br.com.agmg.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agmg.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
