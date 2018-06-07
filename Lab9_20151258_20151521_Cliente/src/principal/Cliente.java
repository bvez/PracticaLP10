package principal;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import interfaces.InterfazRemota;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.Aeropuerto;
import java.util.ArrayList;

public class Cliente{
    public static void main(String[] args){
        try{
            Socket so = new Socket("192.168.207.116",1235);
//            Socket soEscribir = new Socket("192.168.207.116",1235);
            ObjectOutputStream salida = new ObjectOutputStream (so.getOutputStream());
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Sistema de gestión de aeropuertos");
            while(true){
                System.out.println();
                System.out.println("---------------------------------");
                System.out.println("1. Listar Aeropuertos");
                System.out.println("2. Mostrar Datos de un Aeropuerto");
                System.out.println("3. Registrar Aeropuerto");
                System.out.println("0. Salir del Sistema");
                System.out.print("Ingrese seleccion: ");

                String seleccion = entrada.readLine();
                System.out.println();
                
                        ObjectInputStream input = new ObjectInputStream(so.getInputStream());
                try{
                    int codigo = Integer.parseInt(seleccion);
                    if (codigo == 0) break;
                    salida.writeInt(codigo);
                    salida.flush();
                    if(codigo ==1){
//                        ObjectInputStream input = new ObjectInputStream(so.getInputStream());
                        ArrayList<Aeropuerto> lista = (ArrayList<Aeropuerto>) input.readObject();
                        System.out.println("---------------------------");
                        System.out.println("Aeropuertos existentes:");
                        for (int i = 0  ; i<lista.size();i++){
                            Aeropuerto aux = lista.get(i);
                            System.out.print(aux.getCodigo());
                            System.out.print("       ");
                            System.out.println(aux.getNombre());
                        }
                        System.out.println("---------------------------");
                    }
                    else if(codigo ==2){
                        System.out.print("Digite el codigo del aeropuerto: ");
                        String cod = entrada.readLine();
                        salida.writeUTF(cod);
                        salida.flush();
                        System.out.print(cod);
//                        ObjectInputStream input = new ObjectInputStream(so.getInputStream());
                        Aeropuerto aero = (Aeropuerto) input.readObject();
                        
                        
                        System.out.println("---------------------------");
                        System.out.print("Aeropuerto: ");
                        System.out.print(aero.getIdAeropuerto());
                        System.out.print(aero.getNombre());
                        System.out.print(aero.getCodigo());
                        System.out.print(aero.getUbicacion());
                        System.out.print(aero.getMtsAltura());
                        System.out.println("---------------------------");
                    }
                    else if (codigo==3){
//                        salida.writeUTF(cod);
                        System.out.println("---------------------------");
                        System.out.print("Digite los datos: ");
//                        System.out.println("ID:");
                        String nombre,c,ubicacion,altitud;
                        System.out.println("NOMBRE:");
                        nombre=entrada.readLine();
                        System.out.println("CODIGO:");
                        c=entrada.readLine();
                        System.out.println("UBICACION:");
                        ubicacion=entrada.readLine();
                        System.out.println("ALTITUD:");
                        altitud=entrada.readLine();
                        
                        Aeropuerto m = new Aeropuerto();
                        m.setCodigo(c);
                        m.setNombre(nombre);
                        m.setMtsAltura(Integer.parseInt(altitud));
                        m.setUbicacion(ubicacion);
                        salida.writeObject(m);
                        
                        String mensaje = input.readUTF();
                        
                        System.out.print(mensaje);


                    }
                    else {
                        System.out.println("---------------------------");
                        System.out.println("numero incorrecto");
                    }
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }

    //            ArrayList<Aeropuerto> lista ;
    //            for(int i=0;i<lista.size();i++){
    //                    lista.get(i).imprimir();
    //            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}