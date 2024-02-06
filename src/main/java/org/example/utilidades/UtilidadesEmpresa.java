package org.example.utilidades;

import org.example.enumerados.TipoContrato;
import org.example.enumerados.TipoEmpresa;
import org.example.modelos.Contrato;
import org.example.modelos.Empleado;
import org.example.modelos.Empresa;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static org.yaml.snakeyaml.nodes.NodeId.mapping;

public class UtilidadesEmpresa {
    public static List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato){
        List<Empleado> result = new ArrayList<>();
        for(Empleado empleado: empresa.getEmpleados()){
            if (empleado.getContrato().getTipoContrato() == tipoContrato){
                result.add(empleado);
            }
        }
        return result;
    }
    public static List<Empleado> getEmpleadosPorContrato2(Empresa empresa, TipoContrato tipoContrato){
        return empresa.getEmpleados().stream()
                .filter(e->e.getContrato().getTipoContrato().equals(tipoContrato))
                .collect(Collectors.toList());
    }
    public static List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa){
        List<Empleado> result = new ArrayList<>();
        for(Empleado empleado : empresa.getEmpleados()){
            if(empleado.getContrato().getSalarioBase() >=1000){
                result.add(empleado);
            }
        }
        result.sort(Comparator.comparing(e -> e.getContrato().getSalarioBase()));
        return result.reversed();
    }
    public static List<Empleado> getMileuristasOrdenadosPorSalario2(Empresa empresa){
        return empresa.getEmpleados().stream()
                .filter(empleado -> empleado.getContrato().getSalarioBase()>=1000)
                .sorted(Comparator.comparing(e->e.getContrato().getSalarioBase()))
                .collect(Collectors.toList())
                .reversed();
    }
    public static double fondoSalarialEmpresa(Empresa empresa){
        Double result= 0.0;
        for(Empleado e : empresa.getEmpleados()){
            result += e.getContrato().getSalarioBase();
        }
        return result;
    }
    public static double fondoSalarialEmpresa2(Empresa empresa){
        return empresa.getEmpleados().stream()
                .mapToDouble(empleado -> empleado.getContrato().getSalarioBase())
                .sum();

    }
    public static Empleado getMejorPagado(List<Empresa> empresas){
        List<Empleado> empleados = new ArrayList<>();
        for(Empresa empresa : empresas){
            empleados.addAll(empresa.getEmpleados());
        }
        empleados.sort(Comparator.comparing(e->e.getContrato().getSalarioBase()));
        return empleados.reversed().get(0);
    }
    public static Empleado getMejorPagado2(List<Empresa> empresas){
        return empresas.stream()
                .flatMap(empresa -> empresa.getEmpleados().stream())
                .sorted(Comparator.comparing(empleado -> empleado.getContrato().getSalarioBase()))
                .collect(Collectors.toList())
                .reversed()
                .get(0);
    }

    //---------- V4 -----------
    //Que devuelve un mapa con el número de empresas que hay para cada tipo
    public Map<TipoEmpresa, Integer> getNumEmpresasPorTipo(List<Empresa> empresas){
        Map<TipoEmpresa, Integer> result = new HashMap<>();
        for (TipoEmpresa tipoEmpresa : TipoEmpresa.values()){
            Integer cont = 0;
            for (Empresa empresa : empresas){
                if (empresa.getTipoEmpresa().equals(tipoEmpresa)){
                    cont+=1;
                }
            }
            result.put(tipoEmpresa, cont);
        }
        return result;
    }
    public Map<TipoEmpresa, Integer> getNumEmpresasPorTipoStream(List<Empresa> empresas){
        return empresas.stream()
                .collect(Collectors.groupingBy(Empresa::getTipoEmpresa, Collectors.collectingAndThen(Collectors.counting(), Long :: intValue)));
    }
    //Que devuelve un mapa con el número de empleados que hay para cada empresa
    public Map<TipoEmpresa,Integer> getNumEmpleadosPorTipoEmpresa(List<Empresa> empresas){
        Map<TipoEmpresa, Integer> result = new HashMap<>();
        for (TipoEmpresa tipoEmpresa : TipoEmpresa.values()){
            Integer cont = 0;
            for (Empresa empresa : empresas){
                if (empresa.getTipoEmpresa().equals(tipoEmpresa)){
                    cont+= empresa.getEmpleados().size();
                }
            }
            result.put(tipoEmpresa, cont);
        }
        return result;
    }
    public Map<TipoEmpresa,Long> getNumEmpleadosPorTipoEmpresaStream(List<Empresa> empresas){
        return empresas.stream()
                .collect(Collectors.groupingBy(Empresa::getTipoEmpresa, Collectors.summingLong(empresa -> empresa.getEmpleados().size())));
    }
    //Que devuelve un mapa de los empleados de la empresa agrupados por su tipo de contrato
    public Map<TipoContrato, List<Empleado>> getEmpleadosPorTipoContrato(Empresa empresa){
        Map<TipoContrato, List<Empleado>> result = new HashMap<>();
        for (TipoContrato tipoContrato : TipoContrato.values()){
            List<Empleado> listaEmpleados = new ArrayList<>();
            for (Empleado empleado : empresa.getEmpleados()){
                if (empleado.getContrato().getTipoContrato().equals(tipoContrato)) {
                    listaEmpleados.add(empleado);
                }

            }
            result.put(tipoContrato, listaEmpleados);
        }
        return result;
    }
    public static Map<TipoContrato, List<Empleado>> getEmpleadosPorTipoContratoStream(Empresa empresa){
        return empresa.getEmpleados().stream()
                .collect(Collectors.groupingBy(e->e.getContrato().getTipoContrato()));
    }
    //Que hace lo mismo que el apartado anterior pero a partir de una lista de empresas
    public Map<Empresa, Map<TipoContrato, List<Empleado>>> getEmpresaPorTipoContrato(List<Empresa> empresas){
        Map<Empresa, Map<TipoContrato, List<Empleado>>> result = new HashMap<>();
        for (Empresa empresa : empresas){
            result.put(empresa, getEmpleadosPorTipoContrato(empresa));
        }
        return result;
    }
    public static Map<Empresa, Map<TipoContrato, List<Empleado>>> getEmpresaPorTipoContratoStream(List<Empresa> empresas){
        Map<Empresa, Map<TipoContrato, List<Empleado>>> result = new HashMap<>();
        for (Empresa empresa : empresas){
            result.put(empresa, getEmpleadosPorTipoContratoStream(empresa));
        }
        return result;
    }
}
