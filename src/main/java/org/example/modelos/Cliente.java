package org.example.modelos;

import org.example.enumerados.TipoCliente;

import java.util.Objects;

public class Cliente extends Persona{
    private TipoCliente tipoCliente;
    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Cliente(Integer identificador, String dni, String nombre, String apellidos, String direccion, TipoCliente tipoCliente) {
        super(identificador, dni, nombre, apellidos, direccion);
        this.tipoCliente = tipoCliente;
    }

    public Cliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Cliente(Integer identificador, String dni, String nombre, String apellidos, String direccion) {
        super(identificador, dni, nombre, apellidos, direccion);
    }

    public Cliente() {
    }
}
