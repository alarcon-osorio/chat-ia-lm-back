package com.spring.ia.repository;

import com.spring.ia.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository
        extends JpaRepository<Movimiento, Long> {

    List<Movimiento> findTop10ByCuentaIdOrderByFechaDesc(Long cuentaId);
}
