package com.objetos.tp.grupodiez.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estacionamiento")
public class Estacionamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lugar_estacionamiento_id")
    private List<LugarEstacionamiento> lugares;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "dispositivo_id")
    private List<Dispositivos> dispositivos;

    public Estacionamiento() {
    }

    public Estacionamiento(Integer id, List<LugarEstacionamiento> lugares, List<Dispositivos> dispositivos) {
        this.id = id;
        /*
        for (int i = 0; i < 30; i++) {
            lugares.add(new LugarEstacionamiento());
        }
         */
        this.lugares = lugares;
        this.dispositivos = dispositivos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<LugarEstacionamiento> getLugares() {
        return lugares;
    }

    public void setLugares(List<LugarEstacionamiento> lugares) {
        this.lugares = lugares;
    }

    public List<Dispositivos> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivos> dispositivos) {
        this.dispositivos = dispositivos;
    }

    @Override
    public String toString() {
        return "Estacionamiento{" +
                "id=" + id +
                ", lugares=" + lugares +
                ", dispositivos=" + dispositivos +
                '}';
    }
}
