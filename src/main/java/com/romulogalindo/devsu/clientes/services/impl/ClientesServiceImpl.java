package com.romulogalindo.devsu.clientes.services.impl;

import com.romulogalindo.devsu.clientes.beans.ClienteBean;
import com.romulogalindo.devsu.clientes.repository.daos.ClientesDAO;
import com.romulogalindo.devsu.clientes.repository.dto.ClienteDTO;
import com.romulogalindo.devsu.clientes.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    ClientesDAO clientesDAO;

    @Override
    public ClienteDTO nuevoCliente(ClienteBean clienteBean) {
        ClienteDTO newCliente = clientesDAO.save(getDTO(clienteBean));

        return newCliente;
    }

    @Override
    public ClienteDTO buscarPorId(Integer id) {
        return clientesDAO.findById(id).orElse(null);
    }

    @Override
    public ClienteDTO buscarPorClienteid(Long clienteid) {
        return clientesDAO.findByClienteid(clienteid);
    }

    @Override
    public ClienteDTO actualizaCliente(ClienteDTO clienteDTO) {
        return clientesDAO.save(clienteDTO);
    }

    @Override
    public void eliminaCliente(ClienteDTO clienteDTO) {
        clientesDAO.delete(clienteDTO);
    }

    private ClienteDTO getDTO(ClienteBean clienteBean) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombres(clienteBean.getNombres());
        clienteDTO.setDireccion(clienteBean.getDireccion());
        clienteDTO.setContrasena(clienteBean.getContrasena());
        clienteDTO.setTelefono(clienteBean.getTelefono());
        clienteDTO.setEstado(Boolean.TRUE);
        clienteDTO.setClienteid(System.currentTimeMillis());

        return clienteDTO;
    }
}
