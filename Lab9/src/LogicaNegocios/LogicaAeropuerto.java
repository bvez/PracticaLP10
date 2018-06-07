/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import AccesoDatos.AccesoDatosAeropuerto;
import Interfaces.InterfazRemota;
import Modelo.Aeropuerto;
import java.util.ArrayList;

/**
 *
 * @author Bruno Espezúa
 */
public class LogicaAeropuerto extends java.rmi.server.UnicastRemoteObject implements InterfazRemota{
    private AccesoDatosAeropuerto acceso;
    public LogicaAeropuerto() throws java.rmi.RemoteException{
        acceso = new AccesoDatosAeropuerto();
    }
    
    
    @Override
    public ArrayList<Aeropuerto> listarAeropuertos(){
        return acceso.listarAeropuertos();
    }
    
    @Override
    public void mostrarDatosAeropuertos(int id){
        acceso.mostrarDatosAeropuertos(id);
    }
}
