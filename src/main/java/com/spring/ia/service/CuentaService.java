package com.spring.ia.service;

import com.spring.ia.entity.Cuenta;
import com.spring.ia.repository.CuentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public Cuenta obtenerCuenta() {

        return cuentaRepository
                .findByNumeroCuenta("123456")
                .orElseThrow();
    }
}
