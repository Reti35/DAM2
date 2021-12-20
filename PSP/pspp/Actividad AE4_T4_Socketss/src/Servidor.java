import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Ren� Clase Servidor
 *
 */
public class Servidor {

	public static void main(String[] args) {

		try {

			// Iniciamos el servidor que esperara a que se inicie el cliente

			int numeroPuerto = 5000;

			ServerSocket servidor = new ServerSocket(numeroPuerto);

			System.err.println("SERVIDOR >> Escuchando...");

			// Una vez se conecta el cliente le envia una contrase�a vacia

			Socket cliente = servidor.accept();

			ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());

			Contrase�a contrase�a = new Contrase�a("", "");

			outObjeto.writeObject(contrase�a);

			System.err.println("SERVIDOR >> Envio a cliente: " + contrase�a.getContrase�a() + " - "
					+ contrase�a.getContrase�aEncriptada());

			// Recivimos la contrase�a a encriptar

			ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());

			Contrase�a cMod = (Contrase�a) inObjeto.readObject();

			System.err.println("SERVIDOR >> Recibo de cliente: " + cMod.getContrase�a());
			System.err.println("SERVIDOR >> Encriptando contrase�a");

			// Encriptamos la contrase�a y la volvemos a mandar a el cliente

			cMod.setContrase�aEncriptada(cMod.encriptarContrase�a(cMod.getContrase�a()));

			System.err.println(
					"SERVIDOR >> Envio a cliente: " + cMod.getContrase�a() + " - " + cMod.getContrase�aEncriptada());

			outObjeto.writeObject(cMod);

			outObjeto.close();
			inObjeto.close();
			cliente.close();
			servidor.close();

		} catch (ClassNotFoundException | IOException e) {

			e.printStackTrace();

		}

	}
}
