import java.util.ArrayList;

public class APP {

	public static void main(String[] args) {

		// Actividad 1
		sayHello();
		System.out.println("");

		// Actividad 2
		arrayNombres();
		System.out.println("");
		listaNombres();
		System.out.println("");

		// Actividad 3

	}

	// Actividad1 creacion del metodo sayHello que escribe hola mundo por consola
	public static void sayHello() {

		System.out.println("Hola mundo");

	}

	// Actividad 2 mostrar 6 nombres por consola de forma consecutiva con un array
	public static void arrayNombres() {

		String[] nombres = { "Rene", "Yune", "Pau", "Vicent", "Alex", "David" };

		for (int i = 0; i < nombres.length; i++) {

			System.out.println(nombres[i]);

		}

	}

	// Actividad 2 mostarar 6 nombres por consola con un objeto de tipo lista
	public static void listaNombres() {

		ArrayList<String> lista = new ArrayList<>();

		lista.add("Rene");
		lista.add("Yune");
		lista.add("Pau");
		lista.add("Vicent");
		lista.add("Alex");
		lista.add("David");

		System.out.println(lista);

	}

}
