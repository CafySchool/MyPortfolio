package it.its.atmapi.restcontrollers;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.its.atmapi.dto.PeripheralDTO;
import it.its.atmapi.iservices.IPeripheralService;

@RestController
@RequestMapping("/api/peripheral")
public class PeripheralRestController {

	@Autowired
	IPeripheralService iPeripheralService;	
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PeripheralDTO save(@RequestBody PeripheralDTO peripheralDTO) throws EntityNotFoundException {
		return iPeripheralService.save(peripheralDTO);
	}
}
