package org.example.utilidades;

import org.example.enumerados.TipoContrato;
import org.example.modelos.Contrato;
import org.example.modelos.Empleado;
import org.example.modelos.Empresa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UtilidadesEmpresa {
    public static List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato){
        List<Empleado> result = empresa.getEmpleados();
        for(Empleado empleado: result){
            if (empleado.getContrato().getTipoContrato() != tipoContrato){
                result.remove(empleado);
            }
        }
        return result;
    }
    public static List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa){
        List<Empleado> result = new ArrayList<>();
        for(Empleado empleado : empresa.getEmpleados()){
            if(empleado.getContrato().getSalarioBase() >=1000){
                result.add(empleado);
            }
        }
    }

}
