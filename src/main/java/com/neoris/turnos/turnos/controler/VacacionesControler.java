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

	@GetMapping("/traerVacaciones")
	public List<Vacaciones> mostrarVacaciones() {

		return service.mostrarVacaciones();

	}

	@GetMapping("/traerVacacionesId/{id}")
	public ResponseEntity<Vacaciones> mostrarVacacionesId(@PathVariable Integer id) {

		try {
			return new ResponseEntity<Vacaciones>(service.mostrarVacacionesId(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Vacaciones>(HttpStatus.NOT_FOUND);
		}
		

	}

	@PutMapping("/modificarVacacionesId/{id}")
	public ResponseEntity<Vacaciones> modificarVacacionesId(@RequestBody Vacaciones vacaciones, @PathVariable Integer id) {

		
		try {
			return new ResponseEntity<Vacaciones>(service.modificarVacacionesId(vacaciones, id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Vacaciones>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/eliminarVacacionesId/{id}")
	public ResponseEntity<Vacaciones> eliminarVacacionesId(@PathVariable Integer id) {

		
		try {
			service.eliminarVacacionesId(id);
			return new ResponseEntity<Vacaciones>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Vacaciones>(HttpStatus.NOT_FOUND);
		}

	}

}
