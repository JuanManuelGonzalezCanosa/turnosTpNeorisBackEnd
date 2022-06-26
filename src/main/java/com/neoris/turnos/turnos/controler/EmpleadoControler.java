package com.neoris.turnos.turnos.controler;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neoris.turnos.turnos.entity.Empleado;
import com.neoris.turnos.turnos.entity.JornadaLaboral;
import com.neoris.turnos.turnos.service.EmpleadoService;

@RestController
public class EmpleadoControler {

	@Autowired
	private EmpleadoService service;

	
	// MUESTRO LA LISA DE EMPLEADOS
	@GetMapping("/empleados")
	public List<Empleado> lstEmpleado() {
		return service.lstEmpleado();
	}
	
	//MUESTRO EMPLEADO POR ID, UTILIZO UN RESPONSEENTITY PARA SEÑALAR QUE SI TODO SALIO BIEN LO MUESTRO CON EL 200 Y SI SALIO MAL CON EL 404
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> idEmpleado(@PathVariable Integer id) {
		try {
			Empleado empleadoId = service.idEmpleado(id);
			return new ResponseEntity<Empleado>(empleadoId, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
		}
	}
	
	// CREO EL EMPLEADO
	@PostMapping("/crearEmpleado")
	public boolean crearEmpleado(@RequestBody Empleado empleado) {

		service.crearEmpleado(empleado);
		return true;
	}


	//MODIFICO EL EMPLEADO POR EL ID, , UTILIZO UN RESPONSEENTITY PARA SEÑALAR QUE SI TODO SALIO BIEN LO MUESTRO CON EL 200 Y SI SALIO MAL CON EL 404
	@PutMapping("/modificarEmpleado/{id}")
	public ResponseEntity<?> modificarEmpleado(@RequestBody Empleado empleado, @PathVariable Integer id) {

		try {
			Empleado empleadoModificado = service.idEmpleado(id);
			empleadoModificado.setApellido(empleado.getApellido());
			empleadoModificado.setDni(empleado.getDni());
			empleadoModificado.setNombre(empleado.getNombre());
			service.crearEmpleado(empleadoModificado);
			return new ResponseEntity<Empleado>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
		}

	}
	//ELIMINO UN ELPLEADO POR EL ID, UTILIZO UN RESPONSEENTITY PARA SEÑALAR QUE SI TODO SALIO BIEN LO MUESTRO CON EL 200 Y SI SALIO MAL CON EL 404
	@DeleteMapping("/eliminarEmpleado/{id}")
	public ResponseEntity<?> eliminarEmpleadoId(@PathVariable Integer id) {

		try {
			service.eliminarEmpleado(id);
			return new ResponseEntity<Empleado>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
		}

	}
	
	//CARGO 5 JORNADAS LABORALES QUE SERIA DEL LUNES AL VIERNES CON SUS RESPECTIVAS EXCEPCIONES
	@PostMapping("/cargarJornadaLaboralSemanaEmpleado/{id}")
	public void cargarJornadaLaboralSemanaEmpleado(@RequestBody List<JornadaLaboral> jornadaLaboralSemana,
			@PathVariable Integer id) throws Exception {

		service.cargarJornadaLaboralSemanaEmpleado(jornadaLaboralSemana, id);

	}
	
	//MUESTRA TODAS LAS JORNADAS LABORALES DE UN EMPLEADO POR EL ID
	@GetMapping("/listaSemanaTotalesEmpleadoId/{id}")
	public List<JornadaLaboral> listaSemanaTotalesEmpleadoId(@PathVariable Integer id) {

		return service.listahorasPorSemanaTotalesEmpleadoId(id);

	}
	
	//CANTIDAD DE HORAS QUE TIENE EL EMPLEADO POR EL ID
	@GetMapping("/cantidadDeHorasPorSemanaEmpleadoID/{id}")
	public double cantidadDeHorasPorSemanaEmpleadoID(@PathVariable Integer id) {  

		Empleado empleado = service.idEmpleado(id);
		return service.horasDeSemanaPorEmpleadoId(empleado);
	}

	
	//MUESTRO TODOS LOS EMPLEADOS CON LA CANTIDAD DE HORA QUE TIENEN EN CADA JORNADA
	@GetMapping("/cantidadListaEmpleadoSemanal")
	public String cantidadListaEmpleadoSemanal() {	
		
		return service.cantidadListaEmpleadoSemanal(this.lstEmpleado());
	}
	
	
	
	
}
