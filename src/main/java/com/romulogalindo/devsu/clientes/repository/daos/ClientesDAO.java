package com.romulogalindo.devsu.clientes.repository.daos;

import com.romulogalindo.devsu.clientes.repository.dto.ClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ClientesDAO extends JpaRepository<ClienteDTO, Integer> {

    ClienteDTO findByClienteid(Long clienteid);

    ClienteDTO findByNombres(String nombres);

}
