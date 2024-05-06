package com.romulogalindo.devsu.sisbank.controllers;

import com.romulogalindo.devsu.sisbank.beans.CuentaBean;
import com.romulogalindo.devsu.sisbank.beans.MovimientoBean;
import com.romulogalindo.devsu.sisbank.repository.dto.MovimientoDTO;
import com.romulogalindo.devsu.sisbank.services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {

    @Autowired
    MovimientoService movimientoService;


    @GetMapping("/{idMovimiento}")
    public ResponseEntity<MovimientoDTO> buscarMovimientoPorId(@PathVariable Integer idMovimiento) {
        MovimientoDTO movimientoDTO = movimientoService.buscarPorId(idMovimiento);

        if (movimientoDTO != null) {
            return ResponseEntity.ok(movimientoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<MovimientoDTO> crearmovimiento(@RequestBody MovimientoBean movimientoBean) throws Exception {
        return ResponseEntity.ok(movimientoService.nuevoMovimiento(movimientoBean));
    }


    @PutMapping("/{idMovimiento}")
    public ResponseEntity<MovimientoDTO> actualizaMovimiento(@PathVariable Integer idMovimiento, @RequestBody MovimientoBean movimientoBean) throws Exception {
        MovimientoDTO movimientoDTO = movimientoService.buscarPorId(idMovimiento);

        if (movimientoDTO != null) {
            movimientoDTO = movimientoService.actualizaMovimiento(movimientoDTO);

            return ResponseEntity.ok(movimientoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{idMovimiento}")
    public ResponseEntity<Void> eliminaMovimiento(@PathVariable Integer idMovimiento) {
        MovimientoDTO movimientoDTO = movimientoService.buscarPorId(idMovimiento);

        if (movimientoDTO != null) {
            movimientoService.eliminaMovimiento(movimientoDTO);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
