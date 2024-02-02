package org.example.Pruebas;

import org.example.enumerados.TipoContrato;
import org.example.enumerados.TipoEmpresa;
import org.example.modelos.Contrato;
import com.github.javafaker.Faker;
import org.example.modelos.Empleado;
import org.example.modelos.Empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Stack;

public class GeneraDatosPrueba {

    private static final Faker faker = new Faker(new Locale("es"));

    public static Contrato generaContrato(){
        Contrato contrato = new Contrato();
        contrato.setIdenetificador(faker.number().numberBetween(1,999));
        contrato.setSalarioBase(faker.number().randomDouble(2,900,2500));
        contrato.setTipoContrato(TipoContrato.values()[faker.number().numberBetween(0,TipoContrato.values().length)]);
        return contrato;
    }
    public static List<Contrato> generaContratos(Integer n){
        List<Contrato> contratos = new ArrayList<>();
        for(Integer i=0; i==n ; i++){
            contratos.add(generaContrato());
        }
        return contratos;
    }

    public static Empleado generaEmpleado(){
        Empleado empleado = new Empleado();
        empleado.setIdentificador(faker.number().numberBetween(1,999));
        empleado.setNombre(faker.name().firstName());
        empleado.setApellidos(faker.name().lastName());
        empleado.setDireccion(faker.address().fullAddress());
        empleado.setDni(faker.idNumber().valid());
        empleado.setNumTelefono(faker.phoneNumber().cellPhone());
        empleado.setContrato(generaContrato());

        return empleado;
    }

    public static List<Empleado> generaEmpleados(Integer n, Empresa empresa){
        List<Empleado> empleados = new ArrayList<>();
        for(Integer i=0; i<n ; i++){
            Empleado empleado =generaEmpleado();
            empleado.setEmpresa(empresa);
            empleados.add(empleado);
        }
        return empleados;
    }

    public static Empresa generaEmpresa(Integer numEmpleados){
        Empresa empresa= new Empresa();
        empresa.setIdentificador(faker.number().numberBetween(1,999));
        empresa.setCodigoEmpresa(faker.company().name());
        empresa.setTipoEmpresa(TipoEmpresa.values()[faker.number().numberBetween(0, TipoContrato.values().length)]);
        empresa.setEmpleados(generaEmpleados(numEmpleados,empresa));

        return empresa;
    }
}
