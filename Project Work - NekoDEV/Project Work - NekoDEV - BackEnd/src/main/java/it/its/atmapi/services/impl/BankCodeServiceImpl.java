package it.its.atmapi.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.atmapi.domain.BankCode;
import it.its.atmapi.dto.BankCodeDTO;
import it.its.atmapi.iservices.IBankCodeService;
import it.its.atmapi.repositories.BankCodeRepository;
import it.its.atmapi.utils.Convertions;

@Service
public class BankCodeServiceImpl implements IBankCodeService{

	@Autowired
	BankCodeRepository bankCodeRepository;

	@Transactional
	public BankCodeDTO save(BankCodeDTO bankCodeDTO) {
		BankCode bankCode = bankCodeRepository.save(Convertions.bankCodeFromBankCodeDTO(bankCodeDTO));
		bankCodeDTO.setBankCodeId(bankCode.getBankCodeId());
		
		return bankCodeDTO;
	}
}
