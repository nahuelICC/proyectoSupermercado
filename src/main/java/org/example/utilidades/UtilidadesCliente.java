package org.example.utilidades;

import org.example.modelos.Cliente;

import static java.lang.Character.*;

public class UtilidadesCliente {
//    public static Boolean esDniValido(Cliente cliente){
//        if(cliente.getDni().length()==9){
//            Character u = cliente.getDni().charAt(8);
//            if(isAlphabetic(u) && cliente.getDni().substring(0,cliente.getDni().length()-1).matches("[0-9]*")){
//                return Boolean.TRUE;
//            }
//        }else return Boolean.FALSE;
//    }
    public static Boolean esDniValido2(Cliente cliente){
        if(cliente.getDni().length()==9 && cliente.getDni().substring(0,8).matches("[0-9]{8}") && cliente.getDni().substring(8).matches("[a-zA-Z]{1}")){
                return Boolean.TRUE;
        }else return Boolean.FALSE;
    }
}
