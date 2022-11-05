package it.its.atmapi.services.impl;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.atmapi.domain.BankCode;
import it.its.atmapi.domain.Bin;
import it.its.atmapi.domain.Functionality;
import it.its.atmapi.domain.FunctionalityBankCode;
import it.its.atmapi.domain.FunctionalityBin;
import it.its.atmapi.domain.FunctionalityPeripheral;
import it.its.atmapi.domain.Peripheral;
import it.its.atmapi.dto.FunctionalityDTO;
import it.its.atmapi.dto.SelectDTO;
import it.its.atmapi.exceptions.DeleteFunctionalityException;
import it.its.atmapi.iservices.IFunctionalityService;
import it.its.atmapi.repositories.BankCodeRepository;
import it.its.atmapi.repositories.BinRepository;
import it.its.atmapi.repositories.FunctionalityBankCodeRepository;
import it.its.atmapi.repositories.FunctionalityBinRepository;
import it.its.atmapi.repositories.FunctionalityPeripheralRepository;
import it.its.atmapi.repositories.FunctionalityRepository;
import it.its.atmapi.repositories.PeripheralRepository;
import it.its.atmapi.utils.Convertions;


@Service
public class FunctionalityServiceImpl implements IFunctionalityService {

	@Autowired
	FunctionalityRepository functionalityRepository;


	@Autowired
	PeripheralRepository peripheralRepository;
	@Autowired
	FunctionalityPeripheralRepository functionalityPeripheralRepository;
	
	@Autowired
	BinRepository binRepository;
	@Autowired
	FunctionalityBinRepository functionalityBinRepository;
	
	@Autowired
	BankCodeRepository bankCodeRepository;
	@Autowired
	FunctionalityBankCodeRepository functionalityBankCodeRepository;
	
	
	@Override
	@Transactional
	public FunctionalityDTO save(FunctionalityDTO functionalityDTO) {
		Functionality functionality = Convertions.functionalityFromFunctionalityDTO(functionalityDTO);
		
		Functionality functionalitysaved = functionalityRepository.save(functionality);
		
		List<BankCode> bankCodeList = new ArrayList<BankCode>();
		
		for (String bankCodeId : functionalityDTO.getIdBankCode()) {
			BankCode bankCode = bankCodeRepository.findById(bankCodeId).orElseThrow(()-> new EntityNotFoundException());
			bankCodeList.add(bankCode);
		}
		
		for (BankCode bankCode : bankCodeList) {
			FunctionalityBankCode functionalityBankCode = new FunctionalityBankCode();
			functionalityBankCode.setFunctionality(functionalitysaved);
			functionalityBankCode.setBankcode(bankCode);
			functionalityBankCodeRepository.save(functionalityBankCode);
			
		}
		
		List<Bin> binList = new ArrayList<Bin>();
		
		for (String maskedPan : functionalityDTO.getIdBin()) {
			Bin bin = binRepository.findById(maskedPan).orElseThrow(()-> new EntityNotFoundException());
			binList.add(bin);
		}
		
		for (Bin bin : binList) {
			FunctionalityBin functionalityBin = new FunctionalityBin();
			functionalityBin.setFunctionality(functionalitysaved);
			functionalityBin.setBin(bin);
			functionalityBinRepository.save(functionalityBin);
			
		}
		List<Peripheral> peripherals = new ArrayList<Peripheral>();
		
		for (String idPeripheral : functionalityDTO.getIdPeripheral()) {
			Peripheral peripheral = peripheralRepository.findById(idPeripheral).orElseThrow(()-> new EntityNotFoundException());
			peripherals.add(peripheral);
		}
		for (Peripheral peripheral : peripherals) {
			FunctionalityPeripheral functionalityPeripheral = new FunctionalityPeripheral();
			functionalityPeripheral.setFunctionality(functionalitysaved);
			functionalityPeripheral.setPeripheral(peripheral);
			
			functionalityPeripheralRepository.save(functionalityPeripheral);
			
		}
		
		
		functionalityDTO.setId(functionalitysaved.getId());
		
		return functionalityDTO;
	}

	@Override
	@Transactional
	public FunctionalityDTO update(int id, FunctionalityDTO functionalityDTO) {
		Functionality functionality = functionalityRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid user Id:" + id));
		functionality.setName(functionalityDTO.getName());
		functionality.setDescription(functionalityDTO.getDescription());
		functionality.setEnabled(functionalityDTO.isEnabled());
		functionality.setTypeFunc(functionalityDTO.getTypeFunc());
		functionality.setMultisession(functionalityDTO.isMultisession());
		Functionality functionalitysaved = functionalityRepository.save(functionality);
		
		List<BankCode> bankCodeList = new ArrayList<BankCode>();
		
		for (String bankCodeId : functionalityDTO.getIdBankCode()) {
			BankCode bankCode = bankCodeRepository.findById(bankCodeId).orElseThrow(()-> new EntityNotFoundException());
			bankCodeList.add(bankCode);
		}
		
		List<FunctionalityBankCode>functionalityBankCodes = functionalityBankCodeRepository.findByFunctionalityId(id);
		functionalityBankCodeRepository.deleteAll(functionalityBankCodes);
		
		for (BankCode bankCode : bankCodeList) {
			FunctionalityBankCode functionalityBankCode = new FunctionalityBankCode();
			functionalityBankCode.setFunctionality(functionalitysaved);
			functionalityBankCode.setBankcode(bankCode);
			functionalityBankCodeRepository.save(functionalityBankCode);
			
		}
		
		List<Bin> binList = new ArrayList<Bin>();
		
		for (String maskedPan : functionalityDTO.getIdBin()) {
			Bin bin = binRepository.findById(maskedPan).orElseThrow(()-> new EntityNotFoundException());
			binList.add(bin);
		}
		
		List<FunctionalityBin>functionalityBins = functionalityBinRepository.findByFunctionalityId(id);
		functionalityBinRepository.deleteAll(functionalityBins);
		
		for (Bin bin : binList) {
			FunctionalityBin functionalityBin = new FunctionalityBin();
			functionalityBin.setFunctionality(functionalitysaved);
			functionalityBin.setBin(bin);
			functionalityBinRepository.save(functionalityBin);
			
		}
		List<Peripheral> peripherals = new ArrayList<Peripheral>();
		
		for (String idPeripheral : functionalityDTO.getIdPeripheral()) {
			Peripheral peripheral = peripheralRepository.findById(idPeripheral).orElseThrow(()-> new EntityNotFoundException());
			peripherals.add(peripheral);
		}
		
		List<FunctionalityPeripheral>functionalityPeripherals = functionalityPeripheralRepository.findByFunctionalityId(id);
		functionalityPeripheralRepository.deleteAll(functionalityPeripherals);
		
		for (Peripheral peripheral : peripherals) {
			FunctionalityPeripheral functionalityPeripheral = new FunctionalityPeripheral();
			functionalityPeripheral.setFunctionality(functionalitysaved);
			functionalityPeripheral.setPeripheral(peripheral);
			functionalityPeripheralRepository.save(functionalityPeripheral);
			
		}
		
		
		functionalityDTO.setId(functionalitysaved.getId());
		
		
		return functionalityDTO;
	}
	
	@Override
	@Transactional(rollbackOn = DeleteFunctionalityException.class)
	public void delete(int id) throws DeleteFunctionalityException {
		
		Functionality functionality = functionalityRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid user Id:" + id));
		
		List<FunctionalityPeripheral>functionalityPeripherals = functionalityPeripheralRepository.findByFunctionalityId(id);
		for (FunctionalityPeripheral functionalityPeripheral:  functionalityPeripherals ) {
			functionalityPeripheralRepository.delete(functionalityPeripheral);
		}
		List<FunctionalityBankCode>functionalityBankCodes = functionalityBankCodeRepository.findByFunctionalityId(id);
		for (FunctionalityBankCode functionalityBankCode :  functionalityBankCodes ) {
			functionalityBankCodeRepository.delete(functionalityBankCode);
		}
		List<FunctionalityBin>functionalityBins = functionalityBinRepository.findByFunctionalityId(id);
		for (FunctionalityBin functionalityBin :  functionalityBins ) {
			functionalityBinRepository.delete(functionalityBin);
		}
		
		functionalityRepository.delete(functionality);
		
	}

	@Override
	@Transactional(rollbackOn = EntityNotFoundException.class)
	public FunctionalityDTO getById(int id) throws EntityNotFoundException {
		Functionality functionality = functionalityRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid user Id:" + id));
		FunctionalityDTO functionalityDTO = Convertions.functionalityDTOFromFunctionality(functionality);
		return functionalityDTO;
	}

	@Override
	@Transactional
	public List<FunctionalityDTO> findCustom(SelectDTO selectDTO) {
		List<Functionality> functionalitys = functionalityRepository.findCustom(selectDTO.getBankCodeId(), selectDTO.getMaskedPan());	
		List<FunctionalityDTO> functionalityDTOs = new ArrayList<>();
		for(Functionality functionality : functionalitys) {
			if(selectDTO.getIdPeripheral().containsAll(functionality.getFunctionalityPeripherals().stream().map(peripheral -> peripheral.getPeripheral().getIdPeripheral()).toList())) {
				FunctionalityDTO functionalityDTO = Convertions.functionalityDTOFromFunctionality(functionality);
				functionalityDTOs.add(functionalityDTO);
			}
			
			
		}
		
		return functionalityDTOs;
	}
}
