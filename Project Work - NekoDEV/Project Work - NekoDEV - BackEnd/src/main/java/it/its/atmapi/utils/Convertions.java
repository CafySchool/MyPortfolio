package it.its.atmapi.utils;

import java.util.ArrayList;

import it.its.atmapi.domain.BankCode;
import it.its.atmapi.domain.Bin;
import it.its.atmapi.domain.Functionality;

import it.its.atmapi.domain.FunctionalityPeripheral;
import it.its.atmapi.domain.Peripheral;
import it.its.atmapi.dto.BankCodeDTO;
import it.its.atmapi.dto.BinDTO;
import it.its.atmapi.dto.FunctionalityDTO;
import it.its.atmapi.dto.PeripheralDTO;
import it.its.atmapi.dto.TransactionDTO;

public class Convertions {

	public static FunctionalityDTO functionalityDTOFromFunctionality(Functionality functionality) {
		FunctionalityDTO functionalityDTO = new FunctionalityDTO();
		functionalityDTO.setName(functionality.getName());
		functionalityDTO.setDescription(functionality.getDescription());
		functionalityDTO.setEnabled(functionality.isEnabled());
		functionalityDTO.setTypeFunc(functionality.getTypeFunc());
		functionalityDTO.setMultisession(functionality.isMultisession());
		functionalityDTO.setIdPeripheral(new ArrayList<>());
		for(FunctionalityPeripheral functionalityPeripheral : functionality.getFunctionalityPeripherals()) {
			functionalityDTO.getIdPeripheral().add(functionalityPeripheral.getPeripheral().getIdPeripheral());
		}
		functionalityDTO.setIdBankCode(functionality.getFunctionalityBankCodes().stream().map(bankCode -> bankCode.getBankcode().getBankCodeId()).toList());
		functionalityDTO.setIdBin(functionality.getFunctionalityBins().stream().map(bin -> bin.getBin().getMaskedPan()).toList());
		functionalityDTO.setId(functionality.getId());
		return functionalityDTO;
	}
	public static Functionality functionalityFromFunctionalityDTO(FunctionalityDTO functionalityDTO) {
		Functionality functionality = new Functionality();
		functionality.setName(functionalityDTO.getName());
		functionality.setDescription(functionalityDTO.getDescription());
		functionality.setEnabled(functionalityDTO.isEnabled());
		functionality.setTypeFunc(functionalityDTO.getTypeFunc());
		functionality.setMultisession(functionalityDTO.isMultisession());

		return functionality;
	}
	public static Bin binFromBinDTO(BinDTO binDTO) {
		Bin bin = new Bin();
		bin.setMaskedPan(binDTO.getMaskedPan());
		return bin;
	}
	public static BankCode bankCodeFromBankCodeDTO(BankCodeDTO bankCodeDTO) {
		BankCode bankCode = new BankCode();
		bankCode.setBankCodeId(bankCodeDTO.getBankCodeId());
		bankCode.setBankName(bankCodeDTO.getBankName());
		return bankCode;
	}
	public static Peripheral peripheralFromPeripheralDTO(PeripheralDTO peripheralDTO) {
		Peripheral peripheral = new Peripheral();
		peripheral.setIdPeripheral(peripheralDTO.getIdPeripheral());
		peripheral.setName(peripheralDTO.getName());
		return peripheral;
	}
	public static TransactionDTO transactionDTOFromFunctionality(Functionality functionality) {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setName(functionality.getName());
		transactionDTO.setDescription(functionality.getDescription());
		transactionDTO.setEnabled(functionality.isEnabled());
		transactionDTO.setTypeFunc(functionality.getTypeFunc());
		transactionDTO.setMultisession(functionality.isMultisession());
		return transactionDTO;
		
	}
}
