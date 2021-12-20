import java.io.Serializable;

/**
 * 
 * @author Ren�
 * Clase Contrase�a
 *
 */
public class Contrase�a implements Serializable {

	// Parametros
	private static final long serialVersionUID = 1L;
	String contrase�a;
	String contrase�aEncriptada;

	// Constructores
	public Contrase�a() {

	}

	public Contrase�a(String contrase�a, String contrase�aEncriptada) {

		this.contrase�a = contrase�a;
		this.contrase�aEncriptada = contrase�aEncriptada;

	}

	// Getters y Setters
	public Contrase�a(String contrase�a) {

		this.contrase�a = contrase�a;

	}

	public String getContrase�a() {

		return contrase�a;

	}

	public void setContrase�a(String contrase�a) {

		this.contrase�a = contrase�a;

	}

	public String getContrase�aEncriptada() {

		return contrase�aEncriptada;

	}

	public void setContrase�aEncriptada(String contrase�aEncriptada) {

		this.contrase�aEncriptada = contrase�aEncriptada;

	}

	/**
	 * Metodo que dado una contrase�a la encripta cambiando los caracteres por los
	 * siguientes en la tabla ascii.
	 * 
	 * @param contrase�a
	 * @return contrase�aEncriptada
	 */

	public String encriptarContrase�a(String contrase�a) {

		String contrase�aEncriptada = "";

		byte[] pass = contrase�a.getBytes();

		for (int i = 0; i < pass.length; i++) {

			int valorAscii = pass[i] + 1;

			contrase�aEncriptada = contrase�aEncriptada + Character.toString(valorAscii);

		}

		return contrase�aEncriptada;

	}

}
