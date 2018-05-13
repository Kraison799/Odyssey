package server;

import java.io.*;
import java.net.*;
import java.util.logging.*;

public class ServerThread extends Thread {
		private Socket socket;
	    private DataOutputStream output;
	    private DataInputStream input;
	    private int idSessio;
	    
	    public ServerThread(Socket socket, int id) {
	        this.socket = socket;
	        this.idSessio = id;
	        try {
	            output = new DataOutputStream(socket.getOutputStream());
	            input = new DataInputStream(socket.getInputStream());
	        } catch (IOException ex) {
	            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    public void disconnect() {
	        try {
	            socket.close();
	        } catch (IOException ex) {
	            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    @Override
	    public void run() {
	        String accion = "";
	        try {
	            accion = input.readUTF();
	            if(accion.equals("hola")){
	                System.out.println("El cliente con idSesion "+this.idSessio+" saluda");
	                output.writeUTF("adios");
	            }
	        } catch (IOException ex) {
	            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        disconnect();
	    }
}
