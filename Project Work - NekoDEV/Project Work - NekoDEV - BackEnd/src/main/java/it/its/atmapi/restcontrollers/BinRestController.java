package it.its.atmapi.restcontrollers;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.its.atmapi.dto.BinDTO;
import it.its.atmapi.iservices.IBinService;




@RestController
@RequestMapping("/api/bin")
public class BinRestController {
		
		@Autowired
		IBinService iBinService;	
		
		@RequestMapping(value="/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public BinDTO save(@RequestBody BinDTO binDTO) throws EntityNotFoundException {
			return iBinService.save(binDTO);
		}

}
