package com.romulogalindo.devsu.sisbank.services;

import com.romulogalindo.devsu.sisbank.beans.MovimientoBean;
import com.romulogalindo.devsu.sisbank.repository.dto.MovimientoDTO;

public interface MovimientoService {

    MovimientoDTO nuevoMovimiento(MovimientoBean movimientoBean) throws Exception;

    MovimientoDTO buscarPorId(Integer idCuenta);

    MovimientoDTO actualizaMovimiento(MovimientoDTO cuentaDTO);

    void eliminaMovimiento(MovimientoDTO cuentaDTO);
}
