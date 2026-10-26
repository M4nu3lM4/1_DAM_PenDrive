package org.iesalandalus.programacion.poo.pendrive;

import org.iesalandalus.programacion.poo.pendrive.modelo.PenDrive;
import org.iesalandalus.programacion.poo.pendrive.modelo.PenDriveExcepcion;
import org.iesalandalus.programacion.poo.pendrive.vista.Consola;

public class Main {
    public static void main(String[] args) {
        System.out.println("********** PENDRIVE 1 **********");
        PenDrive penDrive1 = new PenDrive();
        System.out.println(penDrive1);
        utilizarPenDrive(penDrive1);
        System.out.println();
        System.out.println("********** PENDRIVE 2 **********");
        PenDrive penDrive2 = new PenDrive("Verbatim",1000);
        System.out.println(penDrive2);
        utilizarPenDrive(penDrive2);


    }


    private static void utilizarPenDrive(PenDrive penDrive){
        try {
            penDrive.escribir(Consola.leerInformacionEscribir());
            System.out.println("Escritura realizada correctamente.");
        } catch (IllegalArgumentException | PenDriveExcepcion e) {
            System.out.println("ERROR AL ESCRIBIR" + e.getMessage());
        }

        try {
            penDrive.borrar(Consola.leerInformacionBorrar());
            System.out.println("Borrado realizado correctamente");
        }catch (IllegalArgumentException | PenDriveExcepcion e){
            System.out.println("ERROR AL BORRAR" + e.getMessage());
        }
    }
}
