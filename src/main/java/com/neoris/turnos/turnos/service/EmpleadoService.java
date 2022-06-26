package com.neoris.turnos.turnos.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.turnos.turnos.entity.Empleado;
import com.neoris.turnos.turnos.entity.JornadaLaboral;
import com.neoris.turnos.turnos.entity.TipoJornadaLaboral;
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
	
	//ELIMINO AL EMPLEADO POR LA ID
	public void eliminarEmpleado(Integer id) {
		repository.deleteById(id);
	}

	
	//CARGO 5 JORNADAS(LUNES A VIERNES) PARA UN EMPLEADO
	public void cargarJornadaLaboralSemanaEmpleado(List<JornadaLaboral> jornadaLaboralSemana, Integer id)
			throws Exception {
		Empleado aux = repository.findById(id).get();

		this.verificacionDelaJornadaLaboral(jornadaLaboralSemana);

		aux.getJornadoLaboral().addAll(jornadaLaboralSemana);
		repository.save(aux);

	}

	//HAGO LAS VERIFICACIONES AL AGREGAR LAS JORNADAS AL EMPLEADO
	@SuppressWarnings("deprecation")
	public void verificacionDelaJornadaLaboral(List<JornadaLaboral> jornadaLaboralSemana) throws Exception {

		if (jornadaLaboralSemana.size() != 5) {
			throw new Exception("Error tiene que cargar 5 jornadas laborales para cada dia de la semana");
		}

		int horaEntrada = 0, horaSalida = 0, totalHoras = 0;
		boolean flag = true;

		for (JornadaLaboral jornadaLaboral : jornadaLaboralSemana) {
			
			horaEntrada = jornadaLaboral.getHoraEntrada().getHour();
			horaSalida = jornadaLaboral.getHoraSalida().getHour();

			totalHoras += horaSalida - horaEntrada;
		}

		if (!flag) {
			throw new Exception("Las horas de las jornadas pueden ser entre 6 y 8");
		}
		if (totalHoras < 30 || totalHoras > 48) {
			throw new Exception("Error el Empleado no puede tener mas de 48 horas y menos de 30 horas");
		}

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
