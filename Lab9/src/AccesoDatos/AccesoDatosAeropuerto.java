/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Aeropuerto;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author alulab14
 */
public class AccesoDatosAeropuerto {
    /*  username = a20151521
        password = QiDSz7
        jdbc:mysql://quilla.lab.inf.pucp.edu.pe
    */
    public void listarAeropuertos(){
        System.out.println("Llama a listar_pacientes. Se imprimira ");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe", "a20151521", "QiDSz7");
            Statement sentencia = con.createStatement();
            String sql = "call LISTAR_PACIENTES()";
            ResultSet rs = sentencia.executeQuery(sql);
            
            while(rs.next()){
                Aeropuerto aer = new Aeropuerto();
                aer.setIdAeropuerto(rs.getInt("ID_PERSONA"));
                aer.setCodigo(rs.getString("DNI"));
                aer.setNombre(rs.getString("NOMBRES")+" "+rs.getString("APELLIDO_PATERNO"));
                aer.setMtsAltura(rs.getInt("EDAD"));
                aer.setUbicacion(rs.getString("APELLIDO_MATERNO"));
                System.out.printf("%-5d %-10s %-32s %-10d %-16s \n",aer.getIdAeropuerto(),aer.getCodigo(),
                                            aer.getNombre(),aer.getMtsAltura(),aer.getUbicacion());
            }
            con.close();
        }
        catch(Exception e){
            System.err.println("Error en listarAeropuertos");
            e.printStackTrace();
        }
    }
    
    public void mostrarDatosAeropuertos(int id){
        System.out.println("Llama a listar_pacientes. Se imprimira ");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe", "a20151521", "QiDSz7");
            Statement sentencia = con.createStatement();
            String sql = "call LISTAR_PACIENTES()";
            ResultSet rs = sentencia.executeQuery(sql);
            
            while(rs.next()){
                Aeropuerto aer = new Aeropuerto();
                aer.setIdAeropuerto(rs.getInt("ID_PERSONA"));
                aer.setCodigo(rs.getString("DNI"));
                aer.setNombre(rs.getString("NOMBRES")+" "+rs.getString("APELLIDO_PATERNO"));
                aer.setMtsAltura(rs.getInt("EDAD"));
                aer.setUbicacion(rs.getString("APELLIDO_MATERNO"));
                System.out.printf("%-5d %-10s %-32s %-10d %-16s \n",aer.getIdAeropuerto(),aer.getCodigo(),
                                            aer.getNombre(),aer.getMtsAltura(),aer.getUbicacion());
            }
            con.close();
        }
        catch(Exception e){
            System.err.println("Error en listarAeropuertos");
            e.printStackTrace();
        }
    }
}
