package com.spring.ia.controller;

import com.spring.ia.entity.Movimiento;
import com.spring.ia.repository.MovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/movimientos")
@RequiredArgsConstructor
public class MovimientoController {

    private final MovimientoRepository repository;

    @GetMapping("/{cuentaId}")
    public List<Movimiento> obtenerMovimientos(
            @PathVariable Long cuentaId) {

        return repository
                .findTop10ByCuentaIdOrderByFechaDesc(
                        cuentaId);
    }
}
