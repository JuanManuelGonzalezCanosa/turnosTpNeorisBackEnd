package com.neoris.turnos.turnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.turnos.turnos.entity.JornadaLaboral;
import com.neoris.turnos.turnos.entity.TurnoExtra;
import com.neoris.turnos.turnos.service.TurnoExtraService;
import com.neoris.turnos.turnos.repository.IJornadaLaboralRepository;
import com.neoris.turnos.turnos.repository.ITurnoExtraRepository;

@Service("jornadaLaboralService")
public class JornadaLaboralService {

	@Autowired
	private IJornadaLaboralRepository repository;
	private TurnoExtraService turnoExtraService;

	// CREO JORNADAS DE TRABAJO CON SUS EXCEPCIONES
	public void crearJornadaLaboral(JornadaLaboral jornadaLaboral) throws Exception {

		this.verificarHorasAlCrearJornadaLaboral(jornadaLaboral);
		repository.save(jornadaLaboral);
	}

	// TRAIGO UNA JORNADA LABORAL POR EL ID
	public JornadaLaboral idJornadaLaboral(Integer id) {
		return repository.findById(id).get();
	}

	// DEVUELVO UNA LISTA DE LA JORNADA LABORAL
	public List<JornadaLaboral> lstJornadaLaboral() {
		return repository.findAll();
	}

	public JornadaLaboral modificarJornadaLaboral(JornadaLaboral jornadaLaboral, Integer id) throws Exception {

		JornadaLaboral aux = this.idJornadaLaboral(id);

		aux.setHoraEntrada(jornadaLaboral.getHoraEntrada());
		aux.setHoraSalida(jornadaLaboral.getHoraSalida());
		aux.setDia(jornadaLaboral.getDia());

		this.verificarHorasAlCrearJornadaLaboral(aux);

		return repository.save(aux);

	}

	// ELIMINO UNA JORNADA LABORAL POR SU ID
	public void eliminarJornadaLaboral(Integer id) {
		repository.deleteById(id);
	}

	private void verificarHorasAlCrearJornadaLaboral(JornadaLaboral jornadaLaboral) throws Exception {

		if (jornadaLaboral.getHoraEntrada().getHour() > jornadaLaboral.getHoraSalida().getHour()) {
			throw new Exception("Error la hora de entrada no puede ser mayoy a la hora de Salida");
		}

		if (((jornadaLaboral.getHoraSalida().getHour() - jornadaLaboral.getHoraEntrada().getHour()) < 6
				|| (jornadaLaboral.getHoraSalida().getHour() - jornadaLaboral.getHoraEntrada().getHour()) > 8)) {
			throw new Exception("La Jornada Completa tiene que tener 6 y 8 Horas");
		}

	}

	// REVISAR!!!!!!!!!!!!
//	public JornadaLaboral cargarTurnoExtraAJornadaLaboral(Integer id) throws Exception {
//		
////		int auxCantHoras = Integer.valueOf(cantHoras);
//		
//		JornadaLaboral auxJornada = repository.findById(id).get();
//		TurnoExtra auxTurnoExtra = null;
//		
//		
//		
//		auxTurnoExtra.setHoraEntrada(auxJornada.getHoraSalida());
//		auxTurnoExtra.setHoraSalida(auxJornada.getHoraEntrada());
//		auxTurnoExtra.setDia(auxJornada.getDia());
//		
//		turnoExtraService.crearTurnoExtra(auxTurnoExtra);
//		
//		auxJornada.setTurnoExtra(auxTurnoExtra);
//		
//		return repository.save(auxJornada);
//	}

	public JornadaLaboral cargarTurnoExtraAJornadaLaboral(TurnoExtra turnoExtra, Integer id) throws Exception {

		JornadaLaboral aux = repository.findById(id).get();
		
		aux.setTurnoExtra(turnoExtra);
		
		this.validarHorasMax(aux);

		return repository.save(aux);

	}

	public void validarHorasMax(JornadaLaboral jornadaLaboral) throws Exception {

		int horaTotal = (jornadaLaboral.getHoraSalida().getHour() - jornadaLaboral.getHoraEntrada().getHour())
				+ (jornadaLaboral.getTurnoExtra().getHoraSalida().getHour()
				- jornadaLaboral.getTurnoExtra().getHoraEntrada().getHour());
		
		if(horaTotal > 12) {
			throw new Exception("No podes trabajar mas de 12 horas entre la jornada normal y el turno extra");
		}

	}

}
