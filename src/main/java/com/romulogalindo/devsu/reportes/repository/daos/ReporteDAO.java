package com.romulogalindo.devsu.reportes.repository.daos;

import com.romulogalindo.devsu.reportes.repository.dto.ReporteDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@org.springframework.stereotype.Repository
public interface ReporteDAO extends Repository<ReporteDTO, Integer> {

    @Query(value = "select mov.id,\n" +
            "       to_char(mov.fecha, 'yyyy-mm-dd')  fecha,\n" +
            "       cli.nombres cliente,\n" +
            "       cue.numero cuenta,\n" +
            "       cue.tipo,\n" +
            "       mov.saldo_inicial,\n" +
            "       mov.estado,\n" +
            "       mov.movimiento,\n" +
            "       mov.saldo_disponible\n" +
            "from movimiento mov\n" +
            "         inner join cuenta cue on mov.cuenta = cue.numero\n" +
            "         inner join cliente cli on cue.cliente = cli.id\n" +
            "where fecha >= to_date(:fecha_ini  , 'yyyy-mm-dd') \n" +
            "  and fecha < to_date( :fecha_fin , 'yyyy-mm-dd') + 1\n" +
            "  and cli.clienteid = :clienteid " +
            "order by fecha asc;", nativeQuery = true)
    List<ReporteDTO> reportePorFechaYCliente(String fecha_ini, String fecha_fin, Long clienteid);

}
