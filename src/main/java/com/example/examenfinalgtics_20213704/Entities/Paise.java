package com.example.examenfinalgtics_20213704.Entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "paises", schema = "gameshop4")
public class Paise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpais", nullable = false)
    private Integer id;

    @Column(name = "iso", length = 2)
    private String iso;

    @Column(name = "nombre", length = 80)
    private String nombre;

    @OneToMany(mappedBy = "idsede")
    private Set<Distribuidora> distribuidoras = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Distribuidora> getDistribuidoras() {
        return distribuidoras;
    }

    public void setDistribuidoras(Set<Distribuidora> distribuidoras) {
        this.distribuidoras = distribuidoras;
    }

}