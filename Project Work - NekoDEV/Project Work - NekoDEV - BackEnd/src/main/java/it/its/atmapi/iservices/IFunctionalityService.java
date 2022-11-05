package it.its.atmapi.iservices;



import java.util.List;

import javax.persistence.EntityNotFoundException;



import it.its.atmapi.dto.FunctionalityDTO;
import it.its.atmapi.dto.SelectDTO;
import it.its.atmapi.exceptions.DeleteFunctionalityException;



public interface IFunctionalityService {

	public FunctionalityDTO save(FunctionalityDTO functionalityDTO);
	public FunctionalityDTO update(int id, FunctionalityDTO functionalityDTO)throws EntityNotFoundException;
	public void delete(int id) throws DeleteFunctionalityException;
	public FunctionalityDTO getById(int id) throws EntityNotFoundException;
	public List<FunctionalityDTO>findCustom(SelectDTO selectDTO);
}
