package com.romulogalindo.devsu.sisbank.services;

import com.romulogalindo.devsu.sisbank.beans.CuentaBean;
import com.romulogalindo.devsu.sisbank.repository.dto.CuentaDTO;

public interface CuentaService {
    CuentaDTO nuevaCuenta(CuentaBean cuentaBean);

    CuentaDTO buscarPorId(Integer idCuenta);

    CuentaDTO actualizaCuenta(CuentaDTO cuentaDTO);

    void eliminaCuenta(CuentaDTO cuentaDTO);
}
