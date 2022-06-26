package com.neoris.turnos.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoris.turnos.turnos.entity.DiaLibre;

@Repository("diaLibreRepository")
public interface IDiaLibreRepository extends JpaRepository<DiaLibre, Integer>{

}