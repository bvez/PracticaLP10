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
package Interfaces;

import java.util.ArrayList;
import Modelo.Aeropuerto;

public interface InterfazRemota extends java.rmi.Remote{
	public ArrayList<Aeropuerto> listarAeropuertos() throws java.rmi.RemoteException;
	public void mostrarDatosAeropuertos(int id) throws java.rmi.RemoteException;
}
