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

import com.neoris.turnos.turnos.entity.TurnoExtra;
import com.neoris.turnos.turnos.service.TurnoExtraService;

@RestController
public class TurnoExtraControler {

	@Autowired
	private TurnoExtraService service;

	@PostMapping("/crearTurnoExtra")
	public boolean crearTurnoExtra(@RequestBody TurnoExtra turnoExtra) {

		service.crearTurnoExtra(turnoExtra);
		return true;

	}

	@GetMapping("/traerTurnosExtras")
	public List<TurnoExtra> traerTurnosExtra() {

		return service.traerTurnosExtras();

	}

	@GetMapping("/traerTurnosExtrasId/{id}")
	public TurnoExtra traerTurnosExtrasId(@PathVariable Integer id) {

		return service.traerTurnosExtrasId(id);
	}

	@PutMapping("/modificarTurnoExtraId/{id}")
	public boolean modificarTurnoExtraId(@RequestBody TurnoExtra turnoExtra, @PathVariable Integer id) {

		service.modificarTurnoExtraId(turnoExtra, id);
		return true;
	}

	@DeleteMapping("/eliminarTurnoExtraId/{id}")
	public boolean eliminarTurnoExtraId(@PathVariable Integer id) {

		service.eliminarTurnoExtraId(id);
		return true;
	}

}
