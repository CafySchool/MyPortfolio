package it.its.atmapi.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.its.atmapi.domain.Functionality;




public interface FunctionalityRepository extends JpaRepository<Functionality, Integer>{
	@Query(value = "SELECT functionality.id, functionality.description, functionality.enabled, functionality.type_func, functionality.multisession, functionality.name  FROM functionality "
			+ "INNER JOIN functionality_bank_code ON functionality.id = functionality_bank_code.functionality_id "
			+ "INNER JOIN functionality_bin ON functionality.id = functionality_bin.functionality_id "
			+ "INNER JOIN functionality_peripheral ON functionality.id = functionality_peripheral.functionality_id "
			+ "WHERE functionality.enabled  AND functionality_bank_code.bankcode_bank_code_id = :bankCodeId AND functionality_bin.bin_masked_pan = :maskedPan "
			+ "GROUP BY functionality.id " 
			//+ "AND functionality_bank_code.functionality_id = functionality.id AND functionality_peripheral.functionality_id = functionality.id AND functionality_bin.functionality_id = functionality.id "
			  , nativeQuery = true)
	public List<Functionality>findCustom(@Param(value ="bankCodeId") String bankCodeId, @Param(value ="maskedPan")String maskedPan);
	
}
