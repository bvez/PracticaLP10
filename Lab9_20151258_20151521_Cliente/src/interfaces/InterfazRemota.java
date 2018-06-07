/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.util.ArrayList;
//import Modelo.Aeropuerto;

/**
 *
 * @author alulab14
 */
package interfaces;

import java.util.ArrayList;
import modelo.Aeropuerto;

public interface InterfazRemota extends java.rmi.Remote{
	public ArrayList<Aeropuerto> listarAeropuertos() throws java.rmi.RemoteException;
	public Aeropuerto mostrarDatosAeropuertos(int id) throws java.rmi.RemoteException;
	public String RegistrarAeropuerto(Aeropuerto nuevoAeropuerto) throws java.rmi.RemoteException;
}
