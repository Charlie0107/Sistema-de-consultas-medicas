package com.ulsa.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulsa.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
	//List<Paciente> findByNombre(String nombre);
	
}
