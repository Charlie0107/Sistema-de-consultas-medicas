package com.ulsa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulsa.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
}
