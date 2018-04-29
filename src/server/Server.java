package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends Thread{
	private ServerSocket server;
	private Socket socket;
	private int port = 9000;
	private PrintStream output;
	private BufferedReader input;
	private String message="0";
	private static Server OdysseyServer;
	//Singleton para definir solo un servidor a la vez
	public static Server getServer(){
		if (OdysseyServer == null){
			OdysseyServer= new Server();
		}
		return OdysseyServer;
	}
	@Override
	public void run(){
		super.run();
		try {
			this.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		
	}
	public void init() throws IOException {
		try {
			System.out.println("Estableciendo Conexión");
			server = new ServerSocket(port);
			socket = new Socket();
			
			System.out.println("Conexión establecida");
			
			
			while (true){
				System.out.println("Esperando cliente...");
				socket = server.accept();
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				output = new PrintStream(socket.getOutputStream());
				System.out.println("Aceptando cliente...");
				System.out.println("recibiendo mensaje");
				//Información por recibir
				
				
				message = input.readLine();//recibe el nombre de un booleano
				System.out.println(message);
				
				System.out.println("mandando mensaje");
				//Información por mandar
				
				String msg=null;//
				
				output.println(msg);
			}
		}catch(Exception e) {}
		finally{
			input.close();
			output.close();
			socket.close();	
		};
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
