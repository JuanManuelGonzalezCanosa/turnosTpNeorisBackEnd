package com.neoris.turnos.turnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.turnos.turnos.entity.Empleado;
import com.neoris.turnos.turnos.entity.JornadaLaboral;
import com.neoris.turnos.turnos.entity.TipoJornadaLaboral;
import com.neoris.turnos.turnos.repository.IJornadaLaboralRepository;
import com.neoris.turnos.turnos.repository.IJornadaLaboralRepository;

import net.bytebuddy.implementation.bytecode.Throw;


@Service("jornadaLaboralService")
public class JornadaLaboralService {
	
	@Autowired
	private IJornadaLaboralRepository repository;
	
	
	//CREO JORNADAS DE TRABAJO CON SUS EXCEPCIONES
	public void crearJornadaLaboral(JornadaLaboral jornadaLaboral) throws Exception{
		
		if(jornadaLaboral.getTipoJornadaLaboral() != TipoJornadaLaboral.JORNADACOMPLETA) {
			throw new Exception("Error solo se crean jornadas completas");
		}
		
		JornadaLaboral aux = jornadaLaboral;
		
		double horaEntrada = aux.getHoraEntrada().getHour();
		double horaSalida = aux.getHoraSalida().getHour();
		
		
		if (((horaSalida - horaEntrada) < 6 || (horaSalida - horaEntrada) > 8) && jornadaLaboral.getTipoJornadaLaboral() == TipoJornadaLaboral.JORNADACOMPLETA) {
			throw new Exception("La Jornada Completa tiene entre 6 y 8 Horas");
		}
		repository.save(jornadaLaboral);
	}
	
	//TRAIGO UNA JORNADA LABORAL POR EL ID
	public JornadaLaboral idJornadaLaboral(Integer id) {
		return repository.findById(id).get();
	}

	
	//DEVUELVO UNA LISTA DE LA JORNADA LABORAL
	public List<JornadaLaboral> lstJornadaLaboral() {
		return repository.findAll();
	}

	
	//ELIMINO UNA JORNADA LABORAL POR SU ID
	public void eliminarJornadaLaboral(Integer id) {
		repository.deleteById(id);
	}
	
	
	//CREO LA JORNADA DE TIEMPO EXTRA(PARA CREAR UN TIEMPO EXTRA PRIMERO TENES Q CREAR LA JORNADA COMPLETA) CON SUS RESPECTIVAS EXCEPCIONES
	public void crearJornadaLaboralTiempoExtra(JornadaLaboral jornadaLaboral, Integer idJornadaLaboral) throws Exception {
		
		JornadaLaboral aux = repository.findById(idJornadaLaboral).get();
		if (aux.getTipoJornadaLaboral() != TipoJornadaLaboral.JORNADACOMPLETA) {
			throw new Exception("Error para agregar el turno Extra se lo tenes que agregar a la Jornada Completa");
		}
		
		double horaEntrada = aux.getHoraEntrada().getHour();
		double horaSalida = aux.getHoraSalida().getHour();
		
		if (((horaSalida - horaEntrada) < 8 || (horaSalida - horaEntrada) > 12) && jornadaLaboral.getTipoJornadaLaboral() == TipoJornadaLaboral.TURNOEXTRA) {
			throw new Exception("Error las horas tiene que ser superior a 8 y menores a 12");
		}
		
		aux.setHoraEntrada(jornadaLaboral.getHoraEntrada());
		aux.setHoraSalida(jornadaLaboral.getHoraSalida());
		aux.setTipoJornadaLaboral(TipoJornadaLaboral.TURNOEXTRA);
		
		repository.save(aux);
	}
	
	public void crearDiaLibre(JornadaLaboral jornadaLaboral) throws Exception {
		
		if(jornadaLaboral.getTipoJornadaLaboral() != TipoJornadaLaboral.DIALIBRE) {
			throw new Exception("Error solo se crean dias libres");
		}
		
		JornadaLaboral aux = jornadaLaboral;
		

		aux.setHoraEntrada(null);
		aux.setHoraSalida(null);
		
		repository.save(aux);
		
	}

}


