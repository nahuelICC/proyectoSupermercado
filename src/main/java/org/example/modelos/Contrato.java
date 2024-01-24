package org.example.modelos;

import org.example.enumerados.TipoContrato;

import java.util.Objects;

public class Contrato {
    private Integer idenetificador;
    private Double salarioBase;
    private TipoContrato tipoContrato;

    public Integer getIdenetificador() {
        return idenetificador;
    }

    public void setIdenetificador(Integer idenetificador) {
        this.idenetificador = idenetificador;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return Objects.equals(idenetificador, contrato.idenetificador) && Objects.equals(salarioBase, contrato.salarioBase) && tipoContrato == contrato.tipoContrato;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idenetificador, salarioBase, tipoContrato);
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "idenetificador=" + idenetificador +
                ", salarioBase=" + salarioBase +
                ", tipoContrato=" + tipoContrato +
                '}';
    }

    public Contrato(Integer idenetificador, Double salarioBase, TipoContrato tipoContrato) {
        this.idenetificador = idenetificador;
        this.salarioBase = salarioBase;
        this.tipoContrato = tipoContrato;
    }

    public Contrato() {
    }
    public Contrato(Contrato contrato) {
        this.idenetificador = contrato.getIdenetificador();
        this.salarioBase = contrato.getSalarioBase();
        this.tipoContrato = contrato.getTipoContrato();
    }
}
