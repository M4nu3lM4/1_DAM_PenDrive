package org.iesalandalus.programacion.poo.pendrive.modelo;

import java.security.PrivateKey;
import java.util.Objects;

public class PenDrive {
    private static final String FABRICANTE_DESCONOCIDO = "Desconocido";
    private static final int CAPACIDAD_MINIMA = 64;
    private static final int CAPACIDAD_MAXIMA = 1024;
    private String fabricante;
    private int capacidad;
    private int ocupado = 0;


    public PenDrive(){
        fabricante = FABRICANTE_DESCONOCIDO;
        capacidad = CAPACIDAD_MINIMA;
    }

    public PenDrive(String fabricante, int capacidad){
        setFabricante(fabricante);
        setCapacidad(capacidad);
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = Objects.requireNonNull(fabricante,"El fabricante no puede ser nulo.");
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad < CAPACIDAD_MINIMA || capacidad > CAPACIDAD_MAXIMA) {
            System.out.println("La capacidad no es correcta. ");
        }
        this.capacidad = capacidad;
    }

    public int getOcupado() {
        return ocupado;
    }

    public int getLibre(){
        return (ocupado - capacidad);
    }

    public boolean estaVacio(){
        return (ocupado == 0);
    }

    public boolean estaLLeno(){
        return (ocupado == capacidad);
    }

    public void escribir(int cantidad)throws PenDriveExcepcion{
        if (cantidad < 0){
            throw new IllegalArgumentException("Debes escribir algo.");
        }
        if (cantidad > getLibre()){
            throw new PenDriveExcepcion("Si se escribe esa cantidad se pasará del limite.");
        }
        ocupado+=capacidad;
    }
    public int leer(int cantidad)throws PenDriveExcepcion{
        if (cantidad < 0){
            throw new IllegalArgumentException("Debes leer algo.");
        }
        if (cantidad > ocupado){
            throw new PenDriveExcepcion("Si se borra esa cantidad se pasará por debajo del limite.");
        }
        return cantidad;
    }

    public void borrar(int cantidad)throws PenDriveExcepcion{
        if (cantidad < 0){
            throw new IllegalArgumentException("Debes borrar algo.");
        }
        if (cantidad > ocupado){
            throw new PenDriveExcepcion("Si se borra esa cantidad se pasará por debajo del limite.");
        }
        ocupado-= capacidad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PenDrive penDrive = (PenDrive) o;
        return capacidad == penDrive.capacidad && ocupado == penDrive.ocupado && Objects.equals(fabricante, penDrive.fabricante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fabricante, capacidad, ocupado);
    }

    @Override
    public String toString() {
        return String.format("[fabricante=%s, capacidad=%s, ocupado=%s]", fabricante, capacidad, ocupado);
    }
}
