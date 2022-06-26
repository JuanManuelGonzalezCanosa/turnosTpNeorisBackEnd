package com.neoris.turnos.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoris.turnos.turnos.entity.Empleado;

@Repository("empleadoRepository")
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer>{
	
	

}
