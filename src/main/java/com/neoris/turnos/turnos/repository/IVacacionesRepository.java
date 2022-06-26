package com.neoris.turnos.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoris.turnos.turnos.entity.Vacaciones;

@Repository("vacacionesRepository")
public interface IVacacionesRepository extends JpaRepository<Vacaciones, Integer>{

}
