import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * @author Ren� Clase Cliente
 *
 */
public class Cliente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {

			String host = "localhost";

			int puerto = 5000;

			// Arancamos el cliente el cual recibira un objeto contrase�a vacio

			System.out.println("CLIENTE >> Arranca cliente");

			Socket cliente = new Socket(host, puerto);

			ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());

			Contrase�a contrase�a = (Contrase�a) inObjeto.readObject();

			System.out.println("CLIENTE >> Recibo del servidor: " + contrase�a.getContrase�a() + " - "
					+ contrase�a.getContrase�aEncriptada());

			// Pedimos al usuario que introduzca una contrase�a para enviarla al servidor y
			// que pueda ser encrpitada

			System.out.print("Inrtroduce una contrase�a : ");

			contrase�a.setContrase�a(sc.next());

			ObjectOutputStream cMod = new ObjectOutputStream(cliente.getOutputStream());

			cMod.writeObject(contrase�a);

			System.out.println("CLIENTE >> Envio al servidor: " + contrase�a.getContrase�a());

			// Recivimos de el servidor la contrase�a encriptada

			contrase�a = (Contrase�a) inObjeto.readObject();

			System.out.println("CLIENTE >> Recibo del servidor: " + contrase�a.getContrase�aEncriptada());

			inObjeto.close();
			cMod.close();
			cliente.close();
			sc.close();

		} catch (ClassNotFoundException | IOException e) {

			e.printStackTrace();

		}

	}

}
