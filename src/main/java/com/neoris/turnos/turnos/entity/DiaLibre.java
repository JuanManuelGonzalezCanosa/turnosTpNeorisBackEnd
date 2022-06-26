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
@Table(name = "diaLibre")
public class DiaLibre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dia", nullable = false)
	private LocalDate dia;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoJornadaLaboral", nullable = false)
	private TipoJornadaLaboral tipoJornadaLaboral = TipoJornadaLaboral.DIALIBRE;

	public DiaLibre(LocalDate dia, TipoJornadaLaboral tipoJornadaLaboral) {
		super();
		this.dia = dia;
		this.tipoJornadaLaboral = tipoJornadaLaboral;
	}

	public DiaLibre() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public TipoJornadaLaboral getTipoJornadaLaboral() {
		return tipoJornadaLaboral;
	}

	public void setTipoJornadaLaboral(TipoJornadaLaboral tipoJornadaLaboral) {
		this.tipoJornadaLaboral = tipoJornadaLaboral;
	}

}
