package com.neoris.turnos.turnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.turnos.turnos.entity.TurnoExtra;
import com.neoris.turnos.turnos.repository.ITurnoExtraRepository;

@Service("turnoExtraService")
public class TurnoExtraService {

	@Autowired
	private ITurnoExtraRepository repository;
	

	public void crearTurnoExtra(TurnoExtra turnoExtra) throws Exception {
		
		this.verificarHorasAlCrearTurnoExtra(turnoExtra);
		repository.save(turnoExtra);
	}

	public List<TurnoExtra> traerTurnosExtras() {

		return repository.findAll();
	}

	public TurnoExtra traerTurnosExtrasId(Integer id) {

		return repository.findById(id).get();
	}

	public TurnoExtra modificarTurnoExtraId(TurnoExtra turnoExtra, Integer id) throws Exception {

		TurnoExtra aux = this.traerTurnosExtrasId(id);
		aux.setHoraEntrada(turnoExtra.getHoraEntrada());
		aux.setHoraSalida(turnoExtra.getHoraSalida());
		aux.setDia(turnoExtra.getDia());

		this.verificarHorasAlCrearTurnoExtra(aux);
		
		return repository.save(aux);

	}

	public void eliminarTurnoExtraId(Integer id) {

		repository.deleteById(id);
	}
	
	private void verificarHorasAlCrearTurnoExtra(TurnoExtra turnoExtra) throws Exception {
		
		if(turnoExtra.getHoraEntrada().getHour() > turnoExtra.getHoraSalida().getHour()) {
			throw new Exception("Error la hora de entrada no puede ser mayoy a la hora de Salida");
		}
		
		if (((turnoExtra.getHoraSalida().getHour() - turnoExtra.getHoraEntrada().getHour()) < 2
				|| (turnoExtra.getHoraSalida().getHour() - turnoExtra.getHoraEntrada().getHour()) > 6)) {
			throw new Exception("La Jornada Completa tiene entre 2 y 6 Horas");
		}
		
	}

}
