import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import Interfaces.InterfazRemota;
import Modelo.Aeropuerto;
import java.util.ArrayList;

public class Cliente{
	public static void main(String[] args){
		try{
			InterfazRemota ir = (InterfazRemota) java.rmi.Naming.lookup("//"+"192.168.1.7"+":1234/rmi");
			ArrayList<Aeropuerto> lista = ir.listarAeropuertos();
			for(int i=0;i<lista.size();i++){
				lista.get(i).imprimir();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}