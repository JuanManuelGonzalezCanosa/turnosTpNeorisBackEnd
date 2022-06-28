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

import com.neoris.turnos.turnos.entity.Empleado;
import com.neoris.turnos.turnos.entity.JornadaLaboral;
import com.neoris.turnos.turnos.entity.TurnoExtra;
import com.neoris.turnos.turnos.service.JornadaLaboralService;

@RestController
public class JornadaLaboralControler {

	@Autowired
	private JornadaLaboralService service;

	// CREO LA JORNADA LABORAL
	@PostMapping("/crearJornadaLaboral")
	public boolean crearJornadaLaboral(@RequestBody JornadaLaboral jornadaLaboral) throws Exception {

		service.crearJornadaLaboral(jornadaLaboral);
		return true;
	}

	// TRAIGO UNA LISTA DE TODAS LAS JORNADAS LABORALES
	@GetMapping("/traerJornadaLaborales")
	public List<JornadaLaboral> lstJornadaLaboral() {

		return service.lstJornadaLaboral();
	}

	// TRAIGO LA JORNADA LABORAL POR SU ID
	@GetMapping("/traerJornadaLaboralesId/{id}")
	public ResponseEntity<JornadaLaboral> idJornadaLaboral(@PathVariable Integer id) {

		try {

			return new ResponseEntity<JornadaLaboral>(service.idJornadaLaboral(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<JornadaLaboral>(HttpStatus.NOT_FOUND);
		}

	}

	// MODIFICO UNA JORNADA LABORAL POR SU ID
	@PutMapping("/modificarJornadaLaboral/{id}")
	public ResponseEntity<JornadaLaboral> modificarJornadaLaboral(@RequestBody JornadaLaboral jornadaLaboral,
			@PathVariable Integer id) {

		try {
			return new ResponseEntity<JornadaLaboral>(service.modificarJornadaLaboral(jornadaLaboral, id),
					HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<JornadaLaboral>(HttpStatus.NOT_FOUND);
		}

	}

	// ELIMINO UNA JORNADA LABORAL POR SU ID
	@DeleteMapping("/eliminarJornadaLaboral/{id}")
	public ResponseEntity<JornadaLaboral> eliminarJornadaLaboralId(@PathVariable Integer id) {

		try {
			service.eliminarJornadaLaboral(id);
			return new ResponseEntity<JornadaLaboral>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<JornadaLaboral>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	// INTENTAR DE ARREGLAR
//	@PostMapping("/cargarTurnoExtraAJornadaLaboral1/{id}")
//	public JornadaLaboral cargarTurnoExtraAJornadaLaboral(@PathVariable Integer id) throws Exception{
//		
//		return service.cargarTurnoExtraAJornadaLaboral(id);
//		
//		try {
//			return new ResponseEntity<JornadaLaboral>(service.cargarTurnoExtraAJornadaLaboral(cantHoras, id) ,HttpStatus.OK);
//		} catch (Exception e) {
//			// TODO: handle exception
//			return new ResponseEntity<JornadaLaboral>(HttpStatus.NOT_FOUND);
//		}
//			
//	}
	
	@PostMapping("/cargarTurnoExtraAJornadaLaboral/{id}")
	public ResponseEntity<JornadaLaboral> cargarTurnoExtraAJornadaLaboral(@RequestBody TurnoExtra turnoExtra, @PathVariable Integer id) throws Exception{
				
		try {
			return new ResponseEntity<JornadaLaboral>(service.cargarTurnoExtraAJornadaLaboral(turnoExtra, id) ,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<JornadaLaboral>(HttpStatus.NOT_FOUND);
		}
			
	}

}
