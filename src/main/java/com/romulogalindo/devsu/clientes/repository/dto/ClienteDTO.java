package com.romulogalindo.devsu.clientes.repository.dto;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "CLIENTE")
public class ClienteDTO extends Persona {
    private Long clienteid;
    private String contrasena;
    private Boolean estado;

    public ClienteDTO() {
    }

    public Long getClienteid() {
        return clienteid;
    }

    public void setClienteid(Long clienteid) {
        this.clienteid = clienteid;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
