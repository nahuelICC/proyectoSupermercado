package org.example.utilidades;

import org.example.modelos.Cliente;
import org.example.modelos.Factura;
import org.example.modelos.LineaFactura;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    //Que devuelve la suma del importe total de las facturas , que pertenecen al cliente pasado como parámetro.ç
    public Double gastoTotalCliente(List<Factura> facturas, Cliente cliente){
        return facturas.stream()
                .filter(f->f.getCliente().equals(cliente))
                .collect(Collectors.summingDouble(f->f.getTotalAPagar()));
    }
    public Double gastoTotalCliente2(List<Factura> facturas, Cliente cliente){
        return facturas.stream()
                .filter(f->f.getCliente().equals(cliente))
                .mapToDouble(Factura::getTotalAPagar)
                .sum();
    }
    public Double totalFacturadoPeriodo(List<Factura> facturas, LocalDate fechaInicio, LocalDate fechaFin){
        Predicate<Factura> pagada = f->f.getPagada().equals(true);
        Predicate<Factura> fechaValida = (f->f.getFechaEmision().isBefore(fechaFin) & f.getFechaEmision().isAfter(fechaInicio));
        return facturas.stream()
                .filter(pagada.and(fechaValida))
                .mapToDouble(Factura::getTotalAPagar)
                .sum();
    }


}
