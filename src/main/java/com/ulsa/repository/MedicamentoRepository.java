package com.ulsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulsa.entity.Medicamento;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{
    
}
