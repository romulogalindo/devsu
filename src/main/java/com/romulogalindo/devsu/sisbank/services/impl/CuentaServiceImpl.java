package com.romulogalindo.devsu.sisbank.services.impl;

import com.romulogalindo.devsu.clientes.repository.daos.ClientesDAO;
import com.romulogalindo.devsu.clientes.repository.dto.ClienteDTO;
import com.romulogalindo.devsu.sisbank.beans.CuentaBean;
import com.romulogalindo.devsu.sisbank.repository.daos.CuentaDAO;
import com.romulogalindo.devsu.sisbank.repository.dto.CuentaDTO;
import com.romulogalindo.devsu.sisbank.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CuentaServiceImpl implements CuentaService {
    @Autowired
    CuentaDAO cuentaDAO;

    @Autowired
    ClientesDAO clientesDAO;


    @Override
    public CuentaDTO nuevaCuenta(CuentaBean cuentaBean) {
        ClienteDTO clienteDTO = clientesDAO.findByNombres(cuentaBean.getCliente());

        CuentaDTO cuentaDTO = cuentaDAO.save(getDTO(cuentaBean, clienteDTO));

        return cuentaDTO;
    }

    @Override
    public CuentaDTO buscarPorId(Integer idCuenta) {
        return cuentaDAO.findById(idCuenta).orElse(null);
    }

    @Override
    public CuentaDTO actualizaCuenta(CuentaDTO cuentaDTO) {
        return cuentaDAO.save(cuentaDTO);
    }

    @Override
    public void eliminaCuenta(CuentaDTO cuentaDTO) {
        cuentaDAO.delete(cuentaDTO);
    }

    private CuentaDTO getDTO(CuentaBean cuentaBean, ClienteDTO clienteDTO) {
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setNumero(cuentaBean.getNumero());
        cuentaDTO.setTipo(cuentaBean.getTipo());
        cuentaDTO.setSaldo(cuentaBean.getSaldo());
        cuentaDTO.setEstado(Boolean.TRUE);
        cuentaDTO.setCliente(clienteDTO.getId());

        return cuentaDTO;
    }
}
