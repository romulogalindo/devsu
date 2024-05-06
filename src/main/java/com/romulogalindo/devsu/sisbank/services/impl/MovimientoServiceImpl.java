package com.romulogalindo.devsu.sisbank.services.impl;

import com.romulogalindo.devsu.clientes.repository.daos.ClientesDAO;
import com.romulogalindo.devsu.clientes.repository.dto.ClienteDTO;
import com.romulogalindo.devsu.sisbank.beans.CuentaBean;
import com.romulogalindo.devsu.sisbank.beans.MovimientoBean;
import com.romulogalindo.devsu.sisbank.repository.daos.CuentaDAO;
import com.romulogalindo.devsu.sisbank.repository.daos.MovimientoDAO;
import com.romulogalindo.devsu.sisbank.repository.dto.CuentaDTO;
import com.romulogalindo.devsu.sisbank.repository.dto.MovimientoDTO;
import com.romulogalindo.devsu.sisbank.services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MovimientoServiceImpl implements MovimientoService {
    @Autowired
    MovimientoDAO movimientoDAO;

    @Autowired
    CuentaDAO cuentaDAO;

    @Autowired
    ClientesDAO clientesDAO;

    private String TIPO_DEPOSITO = "DEPOSITO";
    private String TIPO_RETIRO = "RETIRO";


    @Override
    public MovimientoDTO nuevoMovimiento(MovimientoBean movimientoBean) throws Exception {
        double montoMovimiento = 0d;
        double nuevoMonto = 0d;
        String tipoMovimiento = "";

        if (movimientoBean.getMovimiento() == 0) {
            throw new Exception("Monto invalido para realizar una operación");
        }

        if (movimientoBean.getMovimiento() < 0) {
            montoMovimiento = Math.abs(movimientoBean.getMovimiento());
            tipoMovimiento = TIPO_RETIRO;
        } else {
            montoMovimiento = movimientoBean.getMovimiento();
            tipoMovimiento = TIPO_DEPOSITO;
        }

        CuentaDTO cuentaDTO = cuentaDAO.findByNumero(movimientoBean.getCuenta());
        if (cuentaDTO == null) {
            throw new Exception("La cuenta no existe.");
        }

        if (tipoMovimiento.contentEquals(TIPO_RETIRO) && cuentaDTO.getSaldo() < montoMovimiento) {
            throw new Exception("Saldo no disponible");
        }

        if (tipoMovimiento.contentEquals(TIPO_RETIRO)) {
            nuevoMonto = cuentaDTO.getSaldo() - montoMovimiento;
        } else {
            nuevoMonto = cuentaDTO.getSaldo() + montoMovimiento;
        }

        MovimientoDTO movimientoDTO = new MovimientoDTO();
        movimientoDTO.setCuenta(cuentaDTO.getNumero());
        movimientoDTO.setSaldo_inicial(cuentaDTO.getSaldo());
        movimientoDTO.setMovimiento(montoMovimiento);
        movimientoDTO.setSaldo_disponible(nuevoMonto);
        movimientoDTO.setFecha(new Date());

        movimientoDTO = movimientoDAO.save(movimientoDTO);
        cuentaDTO.setSaldo(nuevoMonto);

        cuentaDAO.save(cuentaDTO);

        return movimientoDTO;
    }

    @Override
    public MovimientoDTO buscarPorId(Integer idCuenta) {
        return movimientoDAO.findById(idCuenta).orElse(null);
    }

    @Override
    public MovimientoDTO actualizaMovimiento(MovimientoDTO movimientoDTO) {
        return movimientoDAO.save(movimientoDTO);
    }

    @Override
    public void eliminaMovimiento(MovimientoDTO cuentaDTO) {
        movimientoDAO.delete(cuentaDTO);
    }
}
