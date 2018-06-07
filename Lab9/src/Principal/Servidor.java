/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import Interfaces.InterfazRemota;
import LogicaNegocios.LogicaAeropuerto;
/**
 *
 * @author Bruno Espezúa
 */
public class Servidor {
    public static void main(String[] args){
        try{
            InterfazRemota ir = new LogicaAeropuerto();
            java.rmi.Naming.rebind("//"+java.net.InetAddress.getLocalHost().getHostAddress()+":1234/rmi", ir);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
