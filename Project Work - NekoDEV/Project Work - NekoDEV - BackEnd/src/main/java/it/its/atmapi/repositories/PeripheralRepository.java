package it.its.atmapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import it.its.atmapi.domain.Peripheral;

public interface PeripheralRepository extends JpaRepository<Peripheral, String>{

}
