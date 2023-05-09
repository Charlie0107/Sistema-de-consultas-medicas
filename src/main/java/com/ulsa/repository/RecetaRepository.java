package com.ulsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulsa.entity.Receta;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {
    
}
