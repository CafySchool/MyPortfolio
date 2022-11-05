package it.its.atmapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import it.its.atmapi.domain.FunctionalityBin;


public interface FunctionalityBinRepository extends JpaRepository<FunctionalityBin, Integer>{
	public List<FunctionalityBin>findByFunctionalityId(int id);
}
