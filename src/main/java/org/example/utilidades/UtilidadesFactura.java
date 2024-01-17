package org.example.utilidades;

import org.example.modelos.Factura;
import org.example.modelos.LineaFactura;

import java.time.LocalDate;
import java.util.List;

public class UtilidadesFactura {
    public static Boolean esFacturaVencida(Factura factura){
        if(factura.getFechaVencimiento().compareTo(LocalDate.now()) >=0){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }
    public static Boolean esFacturaVencida2(Factura factura){
        if(factura.getFechaVencimiento().isBefore(LocalDate.now())){
            return Boolean.FALSE;
        }else {
            return Boolean.TRUE;
        }
    }
    public static Double calcularBaseFactura(Factura factura){
        Double sumaFactura = 0.0;
        for(LineaFactura lineaFactura : factura.getLineaFactura()){
            sumaFactura += lineaFactura.getProducto().getPrecio()* lineaFactura.getCantidad();
        }
        return sumaFactura;
    }
    public static Double calcularTotalAPagar(Factura factura){
        return (calcularBaseFactura(factura)-factura.getDescuento())*factura.getIva();
    }
}
