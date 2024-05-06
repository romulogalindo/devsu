package com.romulogalindo.devsu.clientes.services;

import com.romulogalindo.devsu.clientes.beans.ClienteBean;
import com.romulogalindo.devsu.clientes.repository.dto.ClienteDTO;

public interface ClientesService {
    ClienteDTO nuevoCliente(ClienteBean clienteBean);

    ClienteDTO buscarPorId(Integer id);

    ClienteDTO buscarPorClienteid(Long clienteid);

    ClienteDTO actualizaCliente(ClienteDTO clienteDTO);

    void eliminaCliente(ClienteDTO clienteDTO);
}
