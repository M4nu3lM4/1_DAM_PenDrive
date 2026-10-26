package org.iesalandalus.programacion.poo.pendrive.vista;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    private Consola(){}

    public static int leerInformacionBorrar(){
        int cantidadBorrar;
        do {
            System.out.println("Introduce la cantidad a borrar: ");
            cantidadBorrar = Entrada.entero();
        }while (cantidadBorrar <= 0);
        return cantidadBorrar;
    }

    public static int leerInformacionEscribir(){
        int cantidadEscribir;
        do {
            System.out.println("Introduce la cantidad a escribir: ");
            cantidadEscribir = Entrada.entero();
        }while (cantidadEscribir <= 0);
        return cantidadEscribir;
    }
}
