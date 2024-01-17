package org.example.modelos;

import java.util.Objects;

public class LineaFactura {
    private Integer idetificador, cantidad;
    private Factura factura;
    private Producto producto;

    public Integer getIdetificador() {
        return idetificador;
    }

    public void setIdetificador(Integer idetificador) {
        this.idetificador = idetificador;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "LineaFactura{" +
                "idetificador=" + idetificador +
                ", cantidad=" + cantidad +
                ", factura=" + factura +
                ", producto=" + producto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineaFactura that = (LineaFactura) o;
        return Objects.equals(idetificador, that.idetificador) && Objects.equals(cantidad, that.cantidad) && Objects.equals(factura, that.factura) && Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idetificador, cantidad, factura, producto);
    }

    public LineaFactura(Integer idetificador, Integer cantidad, Factura factura, Producto producto) {
        this.idetificador = idetificador;
        this.cantidad = cantidad;
        this.factura = factura;
        this.producto = producto;
    }

    public LineaFactura() {
    }
    public LineaFactura(LineaFactura lineaFactura) {
        this.idetificador = lineaFactura.getIdetificador();
        this.cantidad = lineaFactura.getCantidad();
        this.factura = lineaFactura.getFactura();
        this.producto = lineaFactura.getProducto();
    }
}
