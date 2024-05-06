package com.romulogalindo.devsu.sisbank.controllers;

import com.romulogalindo.devsu.sisbank.beans.CuentaBean;
import com.romulogalindo.devsu.sisbank.repository.dto.CuentaDTO;
import com.romulogalindo.devsu.sisbank.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class CuentasController {

    @Autowired
    CuentaService cuentaService;


    @GetMapping("/{idCuenta}")
    public ResponseEntity<CuentaDTO> buscarClientePorId(@PathVariable Integer idCuenta) {
        CuentaDTO cuentaDTO = cuentaService.buscarPorId(idCuenta);

        if (cuentaDTO != null) {
            return ResponseEntity.ok(cuentaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<CuentaDTO> crearCuenta(@RequestBody CuentaBean cuentaBean) {
        return ResponseEntity.ok(cuentaService.nuevaCuenta(cuentaBean));
    }

    @PutMapping("/{idCuenta}")
    public ResponseEntity<CuentaDTO> actualizaCuenta(@PathVariable Integer idCuenta, @RequestBody CuentaBean cuentaBean) {
        CuentaDTO cuentaDTO = cuentaService.buscarPorId(idCuenta);

        if (cuentaDTO != null) {
            cuentaDTO.setNumero(cuentaBean.getNumero());
            cuentaDTO.setTipo(cuentaBean.getTipo());
            cuentaDTO.setSaldo(cuentaBean.getSaldo());
//            cuentaDTO.setCliente(cuentaBean.getCliente());
            cuentaDTO = cuentaService.actualizaCuenta(cuentaDTO);

            return ResponseEntity.ok(cuentaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idCuenta}")
    public ResponseEntity<Void> eliminaCuenta(@PathVariable Integer idCuenta) {
        CuentaDTO cuentaDTO = cuentaService.buscarPorId(idCuenta);

        if (cuentaDTO != null) {
            cuentaService.eliminaCuenta(cuentaDTO);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
