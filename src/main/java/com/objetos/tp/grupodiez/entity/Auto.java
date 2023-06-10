package com.objetos.tp.grupodiez.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "matricula")
    private String matricula;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "horaEntrada")
    private LocalTime horaEntrada;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "horaSalida")
    private LocalTime horaSalida;

    public Auto() {
    }

    public Auto(Integer id, String matricula, LocalTime horaSalida) {
        this.id = id;
        this.matricula = matricula;
        this.horaEntrada = LocalTime.now();
        this.horaSalida = horaSalida;
    }

    public Integer getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(id, auto.id) && Objects.equals(matricula, auto.matricula) && Objects.equals(horaEntrada, auto.horaEntrada) && Objects.equals(horaSalida, auto.horaSalida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matricula, horaEntrada, horaSalida);
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                '}';
    }
}
