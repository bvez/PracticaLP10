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
import java.util.ArrayList;

/**
 *
 * @author alulab14
 */
public class AccesoDatosAeropuerto {
    /*  username = a20151521
        password = QiDSz7
        jdbc:mysql://quilla.lab.inf.pucp.edu.pe
    */
    public ArrayList<Aeropuerto> listarAeropuertos(){
        ArrayList<Aeropuerto> lista = new ArrayList<Aeropuerto>();
        System.out.println("Llama a listar_pacientes. Se imprimira ");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/a20151521", "a20151521", "QiDSz7");
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
                lista.add(aer);
                aer.imprimir();
            }
            con.close();
        }
        catch(Exception e){
            System.err.println("Error en listarAeropuertos");
            e.printStackTrace();
        }
        return lista;
    }
    
    public void mostrarDatosAeropuertos(int id){
        System.out.println("Llama a listar_pacientes. Se imprimira ");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/a20151521", "a20151521", "QiDSz7");
            System.out.println("conecta");
            Statement sentencia = con.createStatement();
            String sql = "SELECT * FROM PERSONA INNER JOIN PACIENTE ON PERSONA.ID_PERSONA = PACIENTE.ID_PACIENTE;";
            ResultSet rs = sentencia.executeQuery(sql);
            System.out.println("corre");
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
