package com.neoris.turnos.turnos.entity;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "turnoExtra")
public class TurnoExtra {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@DateTimeFormat(pattern = "HH:mm:ss")
	@Column(name = "horaEntrada", nullable = false)
	private LocalTime horaEntrada;

	@DateTimeFormat(pattern = "HH:mm:ss")
	@Column(name = "horaSalida", nullable = false)
	private LocalTime horaSalida;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dia", nullable = false)
	private LocalDate dia;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipoJornadaLaboral", nullable = false)
	private TipoJornadaLaboral tipoJornadaLaboral = TipoJornadaLaboral.TURNOEXTRA;

	public TurnoExtra(LocalTime horaEntrada, LocalTime horaSalida, LocalDate dia) {
		super();
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.dia = dia;
	}
	
	public TurnoExtra() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
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
