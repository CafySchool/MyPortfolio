package it.its.atmapi.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.atmapi.domain.Peripheral;
import it.its.atmapi.dto.PeripheralDTO;
import it.its.atmapi.iservices.IPeripheralService;
import it.its.atmapi.repositories.PeripheralRepository;
import it.its.atmapi.utils.Convertions;

@Service
public class PeripheralServiceImpl implements IPeripheralService{


	@Autowired
	PeripheralRepository peripheralRepository;

	@Transactional
	public PeripheralDTO save(PeripheralDTO peripheralDTO) {
		Peripheral peripheral = peripheralRepository.save(Convertions.peripheralFromPeripheralDTO(peripheralDTO));
		peripheralDTO.setIdPeripheral(peripheral.getIdPeripheral());
		return peripheralDTO;
	}
}
