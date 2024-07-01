package com.example.examenfinalgtics_20213704.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "factura", schema = "gameshop4")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfactura", nullable = false)
    private Integer id;

    @Column(name = "fechaenvio", nullable = false, length = 50)
    private String fechaEnvio;

    @Column(name = "tarjeta", nullable = false, length = 50)
    private String tarjeta;

    @Column(name = "codigoverificacion", nullable = false, length = 5)
    private String codigoVerificacion;

    @Column(name = "direccion", nullable = false, length = 500)
    private String direccion;

    @Column(name = "monto", nullable = false)
    private Float monto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idjuegosxusuario")
    private Juegosxusuario idjuegosxusuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getCodigoVerificacion() {
        return codigoVerificacion;
    }

    public void setCodigoVerificacion(String codigoVerificacion) {
        this.codigoVerificacion = codigoVerificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Juegosxusuario getIdjuegosxusuario() {
        return idjuegosxusuario;
    }

    public void setIdjuegosxusuario(Juegosxusuario idjuegosxusuario) {
        this.idjuegosxusuario = idjuegosxusuario;
    }

}