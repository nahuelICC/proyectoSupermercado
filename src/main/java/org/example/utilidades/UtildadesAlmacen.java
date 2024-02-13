package org.example.utilidades;

import org.example.modelos.Almacen;
import org.example.modelos.Producto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtildadesAlmacen {
    //El método devuelve true si la suma de los productos que hay en un
    //almacén no supera la capacidad del almacén, teniendo en cuenta todos
    //los productos y todos los almacenes , cada uno con su correspondiente.
    public boolean validarAlmacenes(List<Producto> productos){
        Map<Almacen, Long> aux = productos.stream().collect(Collectors.groupingBy(Producto::getAlmacen, Collectors.counting()));
        for (Almacen almacen : aux.keySet()){
            if (almacen.getCapacidad()-aux.get(almacen)<0) {
                return false;
            }
        }
        return true;
    }
}
