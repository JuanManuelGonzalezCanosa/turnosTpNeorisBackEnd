package com.neoris.turnos.turnos.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<DiaLibre> mostrarDiaLibres(){
		
		return service.mostrarDiaLibres();
	}
	
	@GetMapping("/mostrarDiaLibresId/{id}")
	public DiaLibre mostrarDiaLibresId(@PathVariable Integer id) {
		
		return service.mostrarDiaLibresId(id);
	}
	
	@PutMapping("/modificarDiaLibreId/{id}")
	public boolean modificarDiaLibreId(@RequestBody DiaLibre diaLibre, @PathVariable Integer id) {
		
		service.modificarDiaLibreId(diaLibre, id);
		return true;
	}
	
	@DeleteMapping("/eliminarDiaLibreId/{id}")
	public boolean eliminarDiaLibreId(@PathVariable Integer id) {
		
		service.eliminarDiaLibreId(id);
		return true;
	}
	

}
