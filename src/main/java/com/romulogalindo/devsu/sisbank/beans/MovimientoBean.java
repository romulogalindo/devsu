package com.romulogalindo.devsu.sisbank.beans;

public class MovimientoBean {
    private String cuenta;
    private double movimiento;

    public MovimientoBean() {
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public double getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(double movimiento) {
        this.movimiento = movimiento;
    }
}
