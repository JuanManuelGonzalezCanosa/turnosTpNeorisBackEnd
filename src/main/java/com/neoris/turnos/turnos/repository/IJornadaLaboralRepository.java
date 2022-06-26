package com.neoris.turnos.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoris.turnos.turnos.entity.JornadaLaboral;

@Repository("jornadaLaboralRepository")
public interface IJornadaLaboralRepository extends JpaRepository<JornadaLaboral, Integer>{

}
