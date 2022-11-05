package it.its.atmapi.restcontrollers;


import java.util.List;

import javax.persistence.EntityNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.its.atmapi.dto.FunctionalityDTO;
import it.its.atmapi.dto.SelectDTO;
import it.its.atmapi.exceptions.DeleteFunctionalityException;
import it.its.atmapi.iservices.IFunctionalityService;



@RestController
@RequestMapping("/api/functionality")
public class FunctionalityRestController {

	@Autowired
	IFunctionalityService iFunctionalityService;	
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public FunctionalityDTO save(@RequestBody FunctionalityDTO functionalityDTO) throws EntityNotFoundException {
		return iFunctionalityService.save(functionalityDTO);
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public FunctionalityDTO update(@PathVariable("id") int id, @RequestBody FunctionalityDTO functionalityDTO) throws EntityNotFoundException {
		return iFunctionalityService.update(id, functionalityDTO);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) throws DeleteFunctionalityException {
		iFunctionalityService.delete(id);
	}
	
	@RequestMapping(value="/getById/{id}", method=RequestMethod.GET)
	public FunctionalityDTO getById(@PathVariable("id") int id) throws EntityNotFoundException {
		return iFunctionalityService.getById(id);
	}
	@RequestMapping(value="/findCustom", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<FunctionalityDTO> findCustom(@RequestBody SelectDTO selectDTO) throws EntityNotFoundException {
		return iFunctionalityService.findCustom(selectDTO);
	}
	
}