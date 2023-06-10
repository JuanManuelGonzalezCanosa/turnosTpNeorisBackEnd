package com.neoris.turnos.turnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.turnos.turnos.entity.DiaLibre;
import com.neoris.turnos.turnos.entity.Empleado;
import com.neoris.turnos.turnos.entity.JornadaLaboral;
import com.neoris.turnos.turnos.entity.TurnoExtra;
import com.neoris.turnos.turnos.entity.Vacaciones;
import com.neoris.turnos.turnos.repository.IEmpleadoRepository;

@Service("empleadoService")
public class EmpleadoService {

	@Autowired
	private IEmpleadoRepository repository;

	//CREO EL EMPLEADO
	public void crearEmpleado(Empleado empleado) {
		repository.save(empleado);
	}
	
	//BUSCO EL EMPLEADO POR EL ID
	public Empleado idEmpleado(Integer id) {
		return repository.findById(id).get();
	}

	//LISTA DE TODOS LOS EMPLEADOS
	public List<Empleado> lstEmpleado() {
		return repository.findAll();
	}
	
	public Empleado modificarEmpleadoId(Empleado empleado, Integer id) {
		
		Empleado aux = this.idEmpleado(id);
		aux.setApellido(empleado.getApellido());
		aux.setDni(empleado.getDni());
		aux.setNombre(empleado.getNombre());
		
		return repository.save(aux);
		
	}
	
	//ELIMINO AL EMPLEADO POR LA ID
	public void eliminarEmpleado(Integer id) {
		repository.deleteById(id);
	}

	
	//CARGO 5 JORNADAS(LUNES A VIERNES) PARA UN EMPLEADO
	public Empleado cargarJornadaLaboralAlEmpleadoId(List<JornadaLaboral> jornadaLaboralSemana, Integer id)
			throws Exception {
		
		Empleado aux = repository.findById(id).get();

		this.verificacionDelaJornadaLaboral(jornadaLaboralSemana);

		aux.getJornadoLaboral().addAll(jornadaLaboralSemana);
		return repository.save(aux);

	}
	
	public Empleado cargarDiaLibreAlEmpleadoId(List<DiaLibre> diaLibre, Integer id) {
		
		Empleado aux = repository.findById(id).get();
		
		aux.getDiaLibre().addAll(diaLibre);
		
		return repository.save(aux);
	}
	
	public Empleado cargarVacacionesAlEmpleadoId(List<Vacaciones> vacaciones, Integer id) {
		
		Empleado aux = repository.findById(id).get();
		
		aux.getVacaciones().addAll(vacaciones);
		
		return repository.save(aux);
	}
	

	//HAGO LAS VERIFICACIONES AL AGREGAR LAS JORNADAS AL EMPLEADO
	public void verificacionDelaJornadaLaboral(List<JornadaLaboral> jornadaLaboralSemana) throws Exception {

		// AGREGAR COSAS

	}

	//LISTA DE EMPLEADOS CON TODAS SUS JORNADAS LABORALES
	public List<JornadaLaboral> listahorasPorSemanaTotalesEmpleadoId(Integer id) {

		return repository.findById(id).get().getJornadoLaboral();
	}

	public double horasDeSemanaPorEmpleadoId(Empleado empleado) {

		double horaEntrada = 0, horaSalida = 0, totalHoras = 0;
		List<JornadaLaboral> aux;

		aux = empleado.getJornadoLaboral();

		for (JornadaLaboral jornadaLaboral : aux) {
			horaEntrada = jornadaLaboral.getHoraEntrada().getHour();
			horaSalida = jornadaLaboral.getHoraSalida().getHour();
			totalHoras += horaSalida - horaEntrada;
		}

		return totalHoras;
	}
	
	//MUESTRO A LOS EMPLEADOS CON SUS RESPECTIVAS HORAS TOTALES DE SUS JORNADAS DE TRABAJO
	public String cantidadListaEmpleadoSemanal(List<Empleado> empleados) {
		double horasTotales = 0;
		String aux = "";

		for (Empleado empleado : empleados) {
			horasTotales = this.horasDeSemanaPorEmpleadoId(empleado);

			aux += ("El Empleado Id: " + empleado.getId() + " " + empleado.getNombre() + " " + empleado.getApellido()
					+ " hizo " + horasTotales + " horas \n");
		}

		return aux;
	}


}
