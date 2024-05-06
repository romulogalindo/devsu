package com.romulogalindo.devsu.clientes.controllers;

import com.romulogalindo.devsu.clientes.beans.ClienteBean;
import com.romulogalindo.devsu.clientes.repository.dto.ClienteDTO;
import com.romulogalindo.devsu.clientes.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    ClientesService clientesService;

    @GetMapping("/{clienteid}")
    public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable Long clienteid) {
        ClienteDTO clienteDTO = clientesService.buscarPorClienteid(clienteid);

        if (clienteDTO != null) {
            return ResponseEntity.ok(clienteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteBean clienteBean) {
        return ResponseEntity.ok(clientesService.nuevoCliente(clienteBean));
    }

    @PutMapping("/{clienteid}")
    public ResponseEntity<ClienteDTO> actualizaCliente(@PathVariable Long clienteid, @RequestBody ClienteBean clienteBean) {
        ClienteDTO clienteDTO = clientesService.buscarPorClienteid(clienteid);

        if (clienteDTO != null) {
            clienteDTO.setNombres(clienteBean.getNombres());
            clienteDTO.setDireccion(clienteBean.getDireccion());
            clienteDTO.setTelefono(clienteBean.getTelefono());
            clienteDTO.setContrasena(clienteBean.getContrasena());
            clienteDTO = clientesService.actualizaCliente(clienteDTO);

            return ResponseEntity.ok(clienteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{clienteid}")
    public ResponseEntity<Void> eliminaCLiente(@PathVariable Long clienteid) {
        ClienteDTO clienteDTO = clientesService.buscarPorClienteid(clienteid);

        if (clienteDTO != null) {
            clientesService.eliminaCliente(clienteDTO);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
