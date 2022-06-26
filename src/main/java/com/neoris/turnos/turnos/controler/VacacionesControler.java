package com.neoris.turnos.turnos.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neoris.turnos.turnos.entity.Vacaciones;
import com.neoris.turnos.turnos.service.VacacionesService;

@RestController
public class VacacionesControler {

	@Autowired
	private VacacionesService service;

	@PostMapping("/crearVacaciones")
	public boolean crearVacaciones(@RequestBody Vacaciones vacaciones) {

		service.crearVacaciones(vacaciones);
		return true;

	}

	@GetMapping("/mostrarVacaciones")
	public List<Vacaciones> mostrarVacaciones() {

		return service.mostrarVacaciones();

	}

	@GetMapping("/mostrarVacacionesId/{id}")
	public Vacaciones mostrarVacacionesId(@PathVariable Integer id) {

		return service.mostrarVacacionesId(id);
	}

	@PutMapping("/modificarVacacionesId/{id}")
	public boolean modificarVacacionesId(@RequestBody Vacaciones vacaciones, @PathVariable Integer id) {

		service.modificarVacacionesId(vacaciones, id);
		return true;
	}

	@DeleteMapping("/eliminarVacacionesId/{id}")
	public boolean eliminarVacacionesId(@PathVariable Integer id) {

		service.eliminarVacacionesId(id);
		return true;
	}

}
