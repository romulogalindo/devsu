package com.romulogalindo.devsu.sisbank.repository.daos;

import com.romulogalindo.devsu.sisbank.repository.dto.CuentaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CuentaDAO extends JpaRepository<CuentaDTO, Integer> {

    CuentaDTO findByNumero(String numero);


}
