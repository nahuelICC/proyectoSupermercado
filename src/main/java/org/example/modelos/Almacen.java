package org.example.modelos;

import java.util.Objects;

public class Almacen {
    private Integer identificador, capacidad;
    private String nombre;

    public Integer getIdentificador() {
        return identificador;
    }


    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Integer getCapacidad() {
        return capacidad;
    }


    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Almacen(Integer identificador, String nombre, Integer capacidad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public Almacen() {
    }
    public Almacen(Almacen almacen) {
        this.identificador = almacen.getIdentificador();
        this.nombre = almacen.getNombre();
        this.capacidad = almacen.getCapacidad();
    }

    @Override
    public String toString() {
        return "Almacen{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Almacen almacen = (Almacen) o;
        return Objects.equals(identificador, almacen.identificador) && Objects.equals(capacidad, almacen.capacidad) && Objects.equals(nombre, almacen.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, capacidad, nombre);
    }
}
