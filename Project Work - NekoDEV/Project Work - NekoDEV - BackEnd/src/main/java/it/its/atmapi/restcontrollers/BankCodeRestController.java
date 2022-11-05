package it.its.atmapi.restcontrollers;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.its.atmapi.dto.BankCodeDTO;
import it.its.atmapi.iservices.IBankCodeService;


@RestController
@RequestMapping("/api/bankcode")
public class BankCodeRestController {
	
	@Autowired
	IBankCodeService iBankCodeService;
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BankCodeDTO save(@RequestBody BankCodeDTO bankCodeDTO) throws EntityNotFoundException {
		return iBankCodeService.save(bankCodeDTO);
	}


}
