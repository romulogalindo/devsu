package com.romulogalindo.devsu.reportes.services.impl;

import com.romulogalindo.devsu.reportes.repository.daos.ReporteDAO;
import com.romulogalindo.devsu.reportes.repository.dto.ReporteDTO;
import com.romulogalindo.devsu.reportes.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteServiceImpl implements ReporteService {
    @Autowired
    ReporteDAO reporteDAO;

    @Override
    public List<ReporteDTO> creaReportePorFechayCliente(String fecha_ini, String fecha_fin, Long clienteid) {
        return reporteDAO.reportePorFechaYCliente(fecha_ini,fecha_fin,clienteid);
    }
}
