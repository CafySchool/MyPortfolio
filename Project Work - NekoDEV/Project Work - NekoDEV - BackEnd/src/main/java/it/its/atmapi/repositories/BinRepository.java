package it.its.atmapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import it.its.atmapi.domain.Bin;

public interface BinRepository extends JpaRepository<Bin, String>{

}
