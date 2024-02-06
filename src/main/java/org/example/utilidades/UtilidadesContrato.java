package org.example.utilidades;

import org.example.enumerados.TipoContrato;
import org.example.modelos.Contrato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilidadesContrato {
    //Que devuelve un mapa con cada tipo de contrato y la media de salario base que tienen los contratos de ese tipo
    public static Map<TipoContrato, Double> getSalarioMedioTipoContrato(List<Contrato> contratos) {
        Map<TipoContrato, Double> result = new HashMap<>();
        for (TipoContrato tipoContrato : TipoContrato.values()){
            Double suma = 0.0;
            Double cont = 0.0;
            for (Contrato contrato : contratos){
                if (contrato.getTipoContrato().equals(tipoContrato)){
                    suma+=contrato.getSalarioBase();
                    cont+=1;
                }
            }
            result.put(tipoContrato, suma/cont);
        }
        return result;
    }
    public static Map<TipoContrato, Double> getSalarioMedioTipoContratoStream(List<Contrato> contratos){
        Map<TipoContrato, List<Contrato>> mapaTCListaContratos = contratos.stream().collect(Collectors.groupingBy(Contrato :: getTipoContrato));
        Map<TipoContrato, Double> result = new HashMap<>();
        mapaTCListaContratos.keySet().stream()
                .forEach(k-> result.put(k,mapaTCListaContratos.get(k).stream().mapToDouble(Contrato :: getSalarioBase).average().orElse(0.0)));
        // return result;
        return contratos.stream()
                .collect(Collectors.groupingBy(Contrato :: getTipoContrato, Collectors.averagingDouble(Contrato::getSalarioBase)));
    }
    //Que devuelve un mapa con cada tipo de contrato y el número de contratos que hay de este tipo
    public Map<TipoContrato, Integer> getNumContratosPorTipo(List<Contrato> contratos){
        Map<TipoContrato, Integer> result = new HashMap<>();
        for (TipoContrato tipoContrato : TipoContrato.values()){
            Integer cont = 0;
            for (Contrato contrato : contratos){
                if (contrato.getTipoContrato().equals(tipoContrato)){
                    cont+=1;
                }
            }
            result.put(tipoContrato, cont);
        }
        return result;
    }
    public Map<TipoContrato, Integer> getNumContratosPorTipoStream(List<Contrato> contratos){
        Map<TipoContrato, List<Contrato>> mapaTCListaContratos = contratos.stream().collect(Collectors.groupingBy(Contrato :: getTipoContrato));
        Map<TipoContrato, Integer> result = new HashMap<>();
        mapaTCListaContratos.keySet().stream()
                .forEach(k-> result.put(k,mapaTCListaContratos.get(k).size()));
        //return result;
        //return contratos.stream().collect(Collectors.groupingBy(Contrato :: getTipoContrato, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        return contratos.stream().collect(Collectors.groupingBy(Contrato :: getTipoContrato, Collectors.summingInt(c->1)));
    }

    //Que devuelve un mapa con los tipo de contrato y la lista con todos los contratos que tienen dicho tipo
    public Map<TipoContrato, List<Contrato>> getListContratosPorTipo(List<Contrato> contratos){
        return contratos.stream().collect(Collectors.groupingBy(Contrato :: getTipoContrato));
    }
}