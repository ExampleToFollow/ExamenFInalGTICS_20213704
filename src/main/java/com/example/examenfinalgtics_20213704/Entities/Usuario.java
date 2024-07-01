package com.example.examenfinalgtics_20213704.Entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios", schema = "gameshop4")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario", nullable = false)
    private Integer id;

    @Column(name = "apellidos", length = 45)
    private String apellidos;

    @Column(name = "nombres", length = 45)
    private String nombres;

    @Column(name = "correo", length = 45)
    private String correo;

    @Column(name = "password", length = 65)
    private String password;

    @Column(name = "autorizacion", length = 20)
    private String autorizacion;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(mappedBy = "idusuario")
    private Set<Juegosxusuario> juegosxusuarios = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Juegosxusuario> getJuegosxusuarios() {
        return juegosxusuarios;
    }

    public void setJuegosxusuarios(Set<Juegosxusuario> juegosxusuarios) {
        this.juegosxusuarios = juegosxusuarios;
    }

}