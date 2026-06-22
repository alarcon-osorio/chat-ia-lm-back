package com.spring.ia.controller;

import com.spring.ia.entity.Cuenta;
import com.spring.ia.repository.CuentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cuentas")
@RequiredArgsConstructor
public class CuentaController {

    private final CuentaRepository repository;

    @GetMapping("/{numeroCuenta}")
    public Cuenta obtenerCuenta(
            @PathVariable String numeroCuenta) {

        return repository
                .findByNumeroCuenta(numeroCuenta)
                .orElseThrow();
    }
}
