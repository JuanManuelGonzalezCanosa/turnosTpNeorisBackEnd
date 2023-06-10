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

import com.neoris.turnos.turnos.entity.DiaLibre;
import com.neoris.turnos.turnos.service.DiaLibreService;

@RestController
public class DiaLibreControler {

	@Autowired
	private DiaLibreService service;

	@PostMapping("/crearDiaLibre")
	public boolean crearDiaLibre(@RequestBody DiaLibre diaLibre) {

		service.crearDiaLibre(diaLibre);
		return true;
	}

	@GetMapping("/mostrarDiaLibres")
	public List<DiaLibre> mostrarDiaLibres() {

		return service.mostrarDiaLibres();
	}

	@GetMapping("/mostrarDiaLibresId/{id}")
	public ResponseEntity<DiaLibre> mostrarDiaLibresId(@PathVariable Integer id) {

		try {
			return new ResponseEntity<DiaLibre>(service.mostrarDiaLibresId(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<DiaLibre>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/modificarDiaLibreId/{id}")
	public ResponseEntity<DiaLibre> modificarDiaLibreId(@RequestBody DiaLibre diaLibre, @PathVariable Integer id) {

		try {

			return new ResponseEntity<DiaLibre>(service.modificarDiaLibreId(diaLibre, id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<DiaLibre>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/eliminarDiaLibreId/{id}")
	public ResponseEntity<DiaLibre> eliminarDiaLibreId(@PathVariable Integer id) {

		try {
			service.eliminarDiaLibreId(id);
			return new ResponseEntity<DiaLibre>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<DiaLibre>(HttpStatus.NOT_FOUND);
		}

	}

}
