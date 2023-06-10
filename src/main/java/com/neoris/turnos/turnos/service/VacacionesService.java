package com.neoris.turnos.turnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.turnos.turnos.entity.Empleado;
import com.neoris.turnos.turnos.entity.Vacaciones;
import com.neoris.turnos.turnos.repository.IVacacionesRepository;

@Service("vacacionesService")
public class VacacionesService {

	@Autowired
	private IVacacionesRepository repository;

	public void crearVacaciones(Vacaciones vacaciones) {

		repository.save(vacaciones);

	}

	public List<Vacaciones> mostrarVacaciones() {

		return repository.findAll();

	}

	public Vacaciones mostrarVacacionesId(Integer id) {

		return repository.findById(id).get();

	}

	public Vacaciones modificarVacacionesId(Vacaciones vacaciones, Integer id) {

		Vacaciones aux = this.mostrarVacacionesId(id);

		aux.setDiaInicio(vacaciones.getDiaInicio());
		aux.setDiaFinal(vacaciones.getDiaFinal());

		return repository.save(aux);

	}

	public void eliminarVacacionesId(Integer id) {

		repository.deleteById(id);
	}

}
