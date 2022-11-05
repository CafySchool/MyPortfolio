package it.its.atmapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import it.its.atmapi.domain.FunctionalityBankCode;

public interface FunctionalityBankCodeRepository extends JpaRepository<FunctionalityBankCode, Integer> {
	public List<FunctionalityBankCode>findByFunctionalityId(int id);
}
