package com.neoris.turnos.turnos.entity;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "vacaciones")
public class Vacaciones {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "diaInicio", nullable = false)
	private LocalDate diaInicio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "diaFinal", nullable = false)
	private LocalDate diaFinal;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipoJornadaLaboral", nullable = false)
	private TipoJornadaLaboral tipoJornadaLaboral = TipoJornadaLaboral.VACACIONES;

	public Vacaciones(LocalDate diaInicio, LocalDate diaFinal) {
		super();
		this.diaInicio = diaInicio;
		this.diaFinal = diaFinal;
	}

	public Vacaciones() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDiaInicio() {
		return diaInicio;
	}

	public void setDiaInicio(LocalDate diaInicio) {
		this.diaInicio = diaInicio;
	}

	public LocalDate getDiaFinal() {
		return diaFinal;
	}

	public void setDiaFinal(LocalDate diaFinal) {
		this.diaFinal = diaFinal;
	}

	public TipoJornadaLaboral getTipoJornadaLaboral() {
		return tipoJornadaLaboral;
	}

	public void setTipoJornadaLaboral(TipoJornadaLaboral tipoJornadaLaboral) {
		this.tipoJornadaLaboral = tipoJornadaLaboral;
	}
	
	

}
