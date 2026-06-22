package com.spring.ia.service;

import com.spring.ia.entity.Cuenta;
import com.spring.ia.entity.Movimiento;
import com.spring.ia.repository.MovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final CuentaService cuentaService;

    private final MovimientoRepository movimientoRepository;

    private final LlmService llmService;

    public String responder(String pregunta) {

        Cuenta cuenta =
                cuentaService.obtenerCuenta();

        List<Movimiento> movimientos =
                movimientoRepository
                        .findTop10ByCuentaIdOrderByFechaDesc(
                                cuenta.getId());

        String contexto = construirContexto(
                cuenta,
                movimientos,
                pregunta);

        return llmService.consultar(contexto);
    }

    private String construirContexto(
            Cuenta cuenta,
            List<Movimiento> movimientos,
            String pregunta) {

        StringBuilder sb = new StringBuilder();

        sb.append("""
                Eres un asistente bancario.
                
                Saldo actual:
                """);

        sb.append(cuenta.getSaldo());

        sb.append("\n");

        movimientos.forEach(m ->
                sb.append(
                        m.getDescripcion()
                                + " "
                                + m.getValor()
                                + "\n"));

        sb.append("\nPregunta:\n");

        sb.append(pregunta);

        return sb.toString();
    }
}
