package org.example.modelos;

import java.util.Objects;

public class Empleado {
    private Integer identificador;
    private String dni, nombre, apellidos, direccion, numTelefono;
    private Empresa empresa;
    private Contrato contrato;

    public Empleado(Integer identificador, String dni, String nombre, String apellidos, String direccion, String numTelefono, Empresa empresa, Contrato contrato) {
        this.identificador = identificador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.numTelefono = numTelefono;
        this.empresa = empresa;
        this.contrato = contrato;
    }

    public Empleado() {
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(identificador, empleado.identificador) && Objects.equals(dni, empleado.dni) && Objects.equals(nombre, empleado.nombre) && Objects.equals(apellidos, empleado.apellidos) && Objects.equals(direccion, empleado.direccion) && Objects.equals(numTelefono, empleado.numTelefono) && Objects.equals(empresa, empleado.empresa) && Objects.equals(contrato, empleado.contrato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, dni, nombre, apellidos, direccion, numTelefono, empresa, contrato);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "identificador=" + identificador +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numTelefono='" + numTelefono + '\'' +
                ", empresa=" + empresa +
                ", contrato=" + contrato +
                '}';
    }
    public Empleado(Empleado empleado) {
        this.identificador = empleado.getIdentificador();
        this.dni = empleado.getDni();
        this.nombre = empleado.getNombre();
        this.apellidos = empleado.getApellidos();
        this.direccion = empleado.getDireccion();
        this.numTelefono = empleado.getNumTelefono();
        this.empresa = empleado.getEmpresa();
        this.contrato = empleado.getContrato();
    }
}
