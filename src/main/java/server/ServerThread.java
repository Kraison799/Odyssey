package server;

import abstractDataType.BinarySearchTree;
import abstractDataType.List;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import registry.Digest;
import registry.User;


import java.io.*;
import java.net.*;
import java.security.NoSuchAlgorithmException;
import java.util.logging.*;

public class ServerThread extends Thread {
		private Socket socket;
	    private DataOutputStream output;
	    private DataInputStream input;
	    private int idSessio;
		private BinarySearchTree<User> usersTree =  new BinarySearchTree<>();


	    
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

			try {
				getUserTree();
			} catch (IOException e) {
				e.printStackTrace();
			}

			byte[] data = new byte[16*1024];
            int count = 0;
			File test = new File("userstest.json");
			File usersJson  = new File("users.json");
			ObjectMapper oM = new ObjectMapper();
			oM.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

	        try {
	        	//numero de bytes
                count = input.read(data);
                System.out.println(count);

                //se guarda el tipo de accion en la variable "accion"
                String accion = new String(data);
                accion = accion.substring(0, count);
				System.out.println(accion);

				//se guarda el mensaje den la variable "mensaje"
				String mensaje = new String(data);
				mensaje = mensaje.substring(0, count);
				System.out.println(mensaje);

				User newUser = (User) convertXmlString2DataObject(mensaje,User.class);
				//signIn(oM,usersJson,newUser);
				logIn(usersJson,oM,newUser);


                if("hello".equals(accion)){
                    System.out.println("Server responde: ");
					send("Hola cliente!");
                }
                if("registrar".equals(accion)){
					System.out.println("Server responde: esperando datos del nuevo usuario");

					signIn(oM, usersJson, newUser);
					send("Usuario registrado");
				}
				if("login".equals(accion)){
					System.out.println("Server responde: ");
					logIn(usersJson,oM,newUser);

				}

		} catch (IOException ex) {
	            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
				ex.printStackTrace();
	        } catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			disconnect();
	    }

	private void signIn(ObjectMapper oM,File file,User newUser) throws IOException {

		User[] tmpUsers = oM.readValue(file, User[].class);
		List<User> userList = new List<>();

		for (User tmpUser : tmpUsers) {
			userList.add(tmpUser);
		}
		//Verifica que no exista un usuario con el mismo nombre de usuario.
		for (User x: tmpUsers) {
			if (x == null){
				break;
			}
			else if(x.getUserName().equals(newUser.getUserName())){
				String error = "Nombre de usuario ya existe";
				send(error);
			}
		//Guarda al nuevo usuario en la variable "users".
		userList.add(newUser);
		User[] users = new User[userList.getLength()];
		for (int i = 0; i < userList.getLength(); i++) {
			users[i] = userList.getValue(i);
		}

		oM.writeValue(file,users);
		}
    }

	private void logIn(File archivo,ObjectMapper jsonMapper,User newUser) throws IOException, NoSuchAlgorithmException {
		//Lee el archivo json de los usuarios y lo guarda en una variable.
		User[] users = jsonMapper.readValue(archivo, User[].class);


		//Digest MD5 = new Digest();

		//Verifica que el usuario coincida con alguno ya registrado.
		for (User x: users) {
			if (x == null){
				break;
			} else if (x.getUserName().equals(newUser.getUserName()) &&
					x.getPassword().equals(newUser.getPassword())){
				//Crea una respuesta al cliente
				String aceptado = "Usuario aceptado";
				send(aceptado);
				return;
			}
		}
		//Crea una respuesta al cliente
		send("Invalid username or password");
		//Manda la respuesta al cliente
		//send(xmlMapper.writeValueAsString(response));
	}


	private void send(String response){
		try {
			byte[] bytes = response.getBytes();
			//System.out.println("Text [Byte Format] : " + Arrays.toString(bytes));
			output.write(bytes);


		} catch (Exception e){
			e.printStackTrace();
		}
	}
	private void getUserTree() throws IOException {

		File usersJson = new File("users.json");
		ObjectMapper mapperJson = new ObjectMapper();
		User[] users = mapperJson.readValue(usersJson, User[].class);

		for (User user : users) {
			if (user != null) {
				usersTree.add(user);
				break;
			}
		}
	}

	public static String write2XMLString(Object object)
			throws JsonProcessingException {

		XmlMapper xmlMapper = new XmlMapper();
		// use the line of code for pretty-print XML on console. We should remove it in production.
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

		return xmlMapper.writeValueAsString(object);
	}

	private static Object convertXmlString2DataObject(String xmlString, Class<?> cls)
			throws JsonParseException, JsonMappingException, IOException{

		XmlMapper xmlMapper = new XmlMapper();
		Object object = xmlMapper.readValue(xmlString, cls);
		return object;
	}

}
