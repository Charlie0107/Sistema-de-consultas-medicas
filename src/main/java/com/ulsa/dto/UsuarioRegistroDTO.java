package com.ulsa.dto;

public class UsuarioRegistroDTO {

    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private String password;


    public UsuarioRegistroDTO(){
        super();
    }

    public UsuarioRegistroDTO(Long id, String nombre, String apellido, String email, String password) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }

    public UsuarioRegistroDTO(String nombre, String apellido, String email, String password) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }

    public UsuarioRegistroDTO(String email) {
        super();
        this.email = email;
    }




    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    
}
