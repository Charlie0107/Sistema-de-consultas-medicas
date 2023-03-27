package com.ulsa.entity;

import java.util.Collection;
import java.util.HashSet;
import javax.annotation.Nonnull;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Nonnull
    private String nombre ;
    @Nonnull
    private String apellido;
    @Nonnull
    private String email;
    @Nonnull
    private String password;
   

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "rol_usuario",joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Collection<Rol> roles;

    public Usuario(){
        super();
    }


    public Usuario(long id, String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    
    public Usuario(String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    
    


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Rol> getRoles() {
        return this.roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }
    
    /*
    public boolean hasRol(String rolName){
        Iterator<Rol> iterator = roles.iterator();
        
        while (iterator.hasNext()){
            Rol rol = iterator.next();
            if(rol.getNombre().equals(rolName)){
                return true;
            }
        }

        return false;
    }
    */
    
}
