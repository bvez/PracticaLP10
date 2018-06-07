/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alulab14
 */
package Modelo;

import java.io.Serializable;

public class Aeropuerto implements Serializable{
    
    private int idAeropuerto;
    private String codigo;
    private String nombre;
    private String ubicacion;
    private int mtsAltura;
    /**
     * @return the idAeropuerto
     */
    public int getIdAeropuerto() {
        return idAeropuerto;
    }

    /**
     * @param idAeropuerto the idAeropuerto to set
     */
    public void setIdAeropuerto(int idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the mtsAltura
     */
    public int getMtsAltura() {
        return mtsAltura;
    }

    /**
     * @param mtsAltura the mtsAltura to set
     */
    public void setMtsAltura(int mtsAltura) {
        this.mtsAltura = mtsAltura;
    }
    public void imprimir(){
        System.out.printf("%-5d %-10s %-32s %-10d %-16s \n",this.getIdAeropuerto(),this.getCodigo(),
                                            this.getNombre(),this.getMtsAltura(),this.getUbicacion());
    }
}
