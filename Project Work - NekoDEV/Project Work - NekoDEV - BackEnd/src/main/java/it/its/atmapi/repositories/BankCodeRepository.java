package it.its.atmapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.atmapi.domain.BankCode;


public interface BankCodeRepository extends JpaRepository<BankCode, String> {

}
