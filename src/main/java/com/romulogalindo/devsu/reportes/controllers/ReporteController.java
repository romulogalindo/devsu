package com.romulogalindo.devsu.reportes.controllers;

import com.romulogalindo.devsu.reportes.repository.dto.ReporteDTO;
import com.romulogalindo.devsu.reportes.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {
    @Autowired
    ReporteService reporteService;

    @GetMapping()
    public ResponseEntity<List<ReporteDTO>> buscarClientePorId(@RequestParam String fecha_ini, @RequestParam String fecha_fin, @RequestParam Long clienteid) {
        if (clienteid != null) {
            return ResponseEntity.ok(reporteService.creaReportePorFechayCliente(fecha_ini, fecha_fin, clienteid));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
