package com.romulogalindo.devsu.sisbank.repository.daos;

import com.romulogalindo.devsu.sisbank.repository.dto.MovimientoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface MovimientoDAO extends JpaRepository<MovimientoDTO, Integer> {
}
