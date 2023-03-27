package com.ulsa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ulsa.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    public Usuario findByEmail(String email);
    //@Query
    //public Usuario getUsuarioByEmail(@Param("email") String email);

    /*
    public Long countById(Long id);

    @Query("SELECT u FROM Usuario u WHERE CONCAT(u.id, ' ', u.email, ' ', u.firstName, ' ',"
    + "u.lastName) LIKE %?1%")
    public Page<Usuario> findAll(String keyword, Pageable pageable);

    @Query("UPDATE Usuario u SET u.enabled = ?2 WHERE u.id = ?1")
    @Modifying
    public void updateEnabledStatus(Long id, boolean enabled);
    */
    
}
