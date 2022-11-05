package it.its.atmapi.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.atmapi.domain.Bin;
import it.its.atmapi.dto.BinDTO;
import it.its.atmapi.iservices.IBinService;
import it.its.atmapi.repositories.BinRepository;
import it.its.atmapi.utils.Convertions;

@Service
public class BinServiceImpl implements IBinService{
	
	@Autowired
	BinRepository binRepository;

	@Transactional
	public BinDTO save(BinDTO binDTO) {
		Bin bin = binRepository.save(Convertions.binFromBinDTO(binDTO));
		binDTO.setMaskedPan(bin.getMaskedPan());	
		return binDTO;
	}

}
