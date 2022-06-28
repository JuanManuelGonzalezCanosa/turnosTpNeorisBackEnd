package com.neoris.turnos.turnos.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "apellido", nullable = false)
	private String apellido;

	@Column(name = "dni", nullable = false, unique = true)
	private Integer dni;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "empleado_id")
	private List<JornadaLaboral> jornadoLaboral;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "empleado_id")
	private List<Vacaciones> vacaciones;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "empleado_id")
	private List<DiaLibre> diaLibre;

	public Empleado() {
		super();
	}

	public Empleado(String nombre, String apellido, Integer dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public List<JornadaLaboral> getJornadoLaboral() {
		return jornadoLaboral;
	}

	public void setJornadoLaboral(List<JornadaLaboral> jornadoLaboral) {
		this.jornadoLaboral = jornadoLaboral;
	}

	public List<Vacaciones> getVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(List<Vacaciones> vacaciones) {
		this.vacaciones = vacaciones;
	}

	public List<DiaLibre> getDiaLibre() {
		return diaLibre;
	}

	public void setDiaLibre(List<DiaLibre> diaLibre) {
		this.diaLibre = diaLibre;
	}
	
	

}