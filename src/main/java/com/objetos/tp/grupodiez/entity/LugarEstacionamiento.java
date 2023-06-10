package com.objetos.tp.grupodiez.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "lugarestacionamiento")
public class LugarEstacionamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@Enumerated(EnumType.STRING)
    @Column(name = "ocupado")
    private Boolean ocupado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auto_id")
    private Auto auto;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "hora_entrada")
    private LocalTime horaEntrada;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "hora_salida")
    private LocalTime HoraSalida;

    public LugarEstacionamiento() {
    }

    public LugarEstacionamiento(Integer id, boolean ocupado, Auto auto, LocalTime horaEntrada, LocalTime horaSalida) {
        this.ocupado = ocupado;
        this.auto = auto;
        this.horaEntrada = horaEntrada;
        HoraSalida = horaSalida;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        HoraSalida = horaSalida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LugarEstacionamiento that = (LugarEstacionamiento) o;
        return ocupado == that.ocupado && Objects.equals(id, that.id) && Objects.equals(auto, that.auto) && Objects.equals(horaEntrada, that.horaEntrada) && Objects.equals(HoraSalida, that.HoraSalida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ocupado, auto, horaEntrada, HoraSalida);
    }

    @Override
    public String toString() {
        return "LugarEstacionamiento{" +
                "id=" + id +
                ", ocupado=" + ocupado +
                ", auto=" + auto +
                ", horaEntrada=" + horaEntrada +
                ", HoraSalida=" + HoraSalida +
                '}';
    }
}
