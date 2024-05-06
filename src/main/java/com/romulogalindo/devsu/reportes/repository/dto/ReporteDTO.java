package com.romulogalindo.devsu.reportes.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ReporteDTO {

    @Id
    @JsonIgnore
    private Integer id;

    @JsonProperty("Fecha")
    private String fecha;

    @JsonProperty("Cliente")
    private String cliente;

    @JsonProperty("Cuenta")
    private String cuenta;

    @JsonProperty("Tipo")
    private String tipo;

    @JsonProperty("Saldo Inicial")
    private double saldo_inicial;

    @JsonProperty("Estado")
    private boolean estado;

    @JsonProperty("Movimiento")
    private double movimiento;

    @JsonProperty("Saldo Disponible")
    private double saldo_disponible;

    public ReporteDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo_inicial() {
        return saldo_inicial;
    }

    public void setSaldo_inicial(double saldo_inicial) {
        this.saldo_inicial = saldo_inicial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(double movimiento) {
        this.movimiento = movimiento;
    }

    public double getSaldo_disponible() {
        return saldo_disponible;
    }

    public void setSaldo_disponible(double saldo_disponible) {
        this.saldo_disponible = saldo_disponible;
    }
}
