package com.ulsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulsa.entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{
	
	//List<Medico> findByNombre(String nombre);

}
