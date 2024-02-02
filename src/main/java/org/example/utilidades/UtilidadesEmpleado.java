package org.example.utilidades;

import org.example.modelos.Empleado;
import org.example.modelos.Empresa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilidadesEmpleado {
    //Que devuelve un mapa con las letras del DNI y los empleados cuyo dni contiene esa letra
    public Map<String, List<Empleado>> getEmpleadosPorLetraDNI(List<Empleado> empleados){
        Map<String, List<Empleado>> result = new HashMap<>();
        for (Empleado empleado : empleados){
            result.put(empleado.getDni().substring(7), null);

        }
        for (String c : result.keySet()){
            List<Empleado> listaEmpleados = new ArrayList<>();
            for (Empleado empleado : empleados){
                if (empleado.getDni().substring(7).equals(c)){
                    listaEmpleados.add(empleado);
                }
            }
            result.put(c, listaEmpleados);
        }
        return result;
    }
    public Map<String, List<Empleado>> getEmpleadosPorLetraDNIStream(List<Empleado> empleados){
        return empleados.stream()
                .collect(Collectors.groupingBy(e->e.getDni().substring(8)));
    }
    //Que devuelve un mapa los empleados agrupados por la empresa a la que pertenecen.
    public Map<Empresa, List<Empleado>> getEmpleadosPorEmpresa(List<Empleado> empleados){
        Map<Empresa, List<Empleado>> result = new HashMap<>();
        for (Empleado empleado : empleados){
            result.put(empleado.getEmpresa(), null);
        }
        for (Empresa empresa : result.keySet()){
            List<Empleado> listaEmpresas = new ArrayList<>();
            for (Empleado empleado : empleados){
                if (empleado.getEmpresa().equals(empresa)){
                    listaEmpresas.add(empleado);
                }
            }
            result.put(empresa, listaEmpresas);
        }
        return result;
    }
    public Map<Empresa, List<Empleado>> getEmpleadosPorEmpresaStream(List<Empleado> empleados){
        return empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getEmpresa));
    }
}
