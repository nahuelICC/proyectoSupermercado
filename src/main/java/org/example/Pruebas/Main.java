package org.example.Pruebas;

import org.example.modelos.Empresa;
import org.example.utilidades.UtilidadesEmpresa;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(GeneraDatosPrueba.generaContrato());

        System.out.println(GeneraDatosPrueba.generaEmpleado());
        System.out.println(GeneraDatosPrueba.generaEmpresa(10));
        List<Empresa> empresas = GeneraDatosPrueba.generaEmpresas(2);
//        System.out.println(empresas);
        System.out.println(UtilidadesEmpresa.getEmpresaPorTipoContratoStream(empresas));
        System.out.println(UtilidadesEmpresa.getEmpleadosPorTipoContratoStream(GeneraDatosPrueba.generaEmpresa()));
    }
}
