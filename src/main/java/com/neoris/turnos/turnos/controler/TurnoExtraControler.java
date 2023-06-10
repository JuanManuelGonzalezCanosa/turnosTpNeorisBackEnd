package com.neoris.turnos.turnos.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public boolean crearTurnoExtra(@RequestBody TurnoExtra turnoExtra) throws Exception {

		service.crearTurnoExtra(turnoExtra);
		return true;

	}

	@GetMapping("/traerTurnosExtras")
	public List<TurnoExtra> traerTurnosExtra() {

		return service.traerTurnosExtras();

	}

	@GetMapping("/traerTurnosExtrasId/{id}")
	public ResponseEntity<TurnoExtra> traerTurnosExtrasId(@PathVariable Integer id) {

		try {
			return new ResponseEntity<TurnoExtra>(service.traerTurnosExtrasId(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<TurnoExtra>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/modificarTurnoExtraId/{id}")
	public ResponseEntity<TurnoExtra> modificarTurnoExtraId(@RequestBody TurnoExtra turnoExtra,
			@PathVariable Integer id) {

		try {
			return new ResponseEntity<TurnoExtra>(service.modificarTurnoExtraId(turnoExtra, id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<TurnoExtra>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/eliminarTurnoExtraId/{id}")
	public ResponseEntity<TurnoExtra> eliminarTurnoExtraId(@PathVariable Integer id) {

		try {
			service.eliminarTurnoExtraId(id);
			return new ResponseEntity<TurnoExtra>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<TurnoExtra>(HttpStatus.NOT_FOUND);
		}

	}

}
