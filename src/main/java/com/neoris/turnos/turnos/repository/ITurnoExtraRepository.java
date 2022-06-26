package com.neoris.turnos.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoris.turnos.turnos.entity.TurnoExtra;

@Repository("turnoExtraRepository")
public interface ITurnoExtraRepository extends JpaRepository<TurnoExtra, Integer>{

}
