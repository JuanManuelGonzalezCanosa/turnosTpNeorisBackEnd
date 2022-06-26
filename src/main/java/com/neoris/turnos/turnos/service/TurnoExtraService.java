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

	public void crearTurnoExtra(TurnoExtra turnoExtra) {

		repository.save(turnoExtra);
	}

	public List<TurnoExtra> traerTurnosExtras() {

		return repository.findAll();
	}

	public TurnoExtra traerTurnosExtrasId(Integer id) {

		return repository.findById(id).get();
	}

	public void modificarTurnoExtraId(TurnoExtra turnoExtra, Integer id) {

		TurnoExtra aux = this.traerTurnosExtrasId(id);
		aux.setHoraEntrada(turnoExtra.getHoraEntrada());
		aux.setHoraSalida(turnoExtra.getHoraSalida());
		aux.setDia(turnoExtra.getDia());

		repository.save(aux);

	}

	public void eliminarTurnoExtraId(Integer id) {

		repository.deleteById(id);
	}

}
