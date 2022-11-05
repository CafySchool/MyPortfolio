package it.its.atmapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.atmapi.domain.FunctionalityPeripheral;

public interface FunctionalityPeripheralRepository extends JpaRepository<FunctionalityPeripheral, Integer>{
	public List<FunctionalityPeripheral>findByFunctionalityId(int id);
}
