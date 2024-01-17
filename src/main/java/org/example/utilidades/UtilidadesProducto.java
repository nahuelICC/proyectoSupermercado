package org.example.utilidades;

import org.example.enumerados.TipoProducto;
import org.example.modelos.Almacen;
import org.example.modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesProducto {
    public List<Producto> getPorTipo(List<Producto> productos, TipoProducto tipo){
        List<Producto> result = new ArrayList<>();
        for (Producto producto : productos){
            if (producto.getTipoProducto().equals(tipo)){
                result.add(producto);
            }
        }
        return result;
    }
    public List<Producto> getPorAlmacen(List<Producto> productos, Almacen almacen){
        List<Producto> result = new ArrayList<>();
        for (Producto producto : productos){
            if (producto.getAlmacen().equals(almacen)){
                result.add(producto);
            }
        }
        return result;
    }
}
