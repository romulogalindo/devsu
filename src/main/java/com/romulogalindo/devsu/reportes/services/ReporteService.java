package com.romulogalindo.devsu.reportes.services;

import com.romulogalindo.devsu.reportes.repository.dto.ReporteDTO;

import java.util.List;

public interface ReporteService {
    List<ReporteDTO> creaReportePorFechayCliente(String fecha_ini, String fecha_fin, Long clienteid);
}
