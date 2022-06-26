package com.neoris.turnos.turnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.turnos.turnos.entity.DiaLibre;
import com.neoris.turnos.turnos.repository.IDiaLibreRepository;

@Service("diaLibreService")
public class DiaLibreService {

	@Autowired
	private IDiaLibreRepository repository;

	public void crearDiaLibre(DiaLibre diaLibre) {

		repository.save(diaLibre);
	}

	public List<DiaLibre> mostrarDiaLibres() {

		return repository.findAll();
	}

	public DiaLibre mostrarDiaLibresId(Integer id) {

		return repository.findById(id).get();
	}

	public void modificarDiaLibreId(DiaLibre diaLibre, Integer id) {

		DiaLibre aux = this.mostrarDiaLibresId(id);

		aux.setDia(diaLibre.getDia());
		repository.save(aux);
	}

	public void eliminarDiaLibreId(Integer id) {

		repository.deleteById(id);
	}

}
