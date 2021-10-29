import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int opcio = 0;
		int identificador = 0;
		Biblioteca biblioteca = new Biblioteca();
		
		System.out.println("Benvingut a la biblioteca");

		do {
			
			System.out.println("Trie una opcio : ");
			System.out.println("1) Mostrar tots els títols de la biblioteca");
			System.out.println("2) Mostrar informació detallada d’un llibre");
			System.out.println("3) Crear nou llibre");
			System.out.println("4) Actualitzar llibre");
			System.out.println("5) Borrar llibre");
			System.out.println("6) Tanca la biblioteca");
			opcio = sc.nextInt();
			
			
			switch (opcio) {
			
			case 1:
				
				ArrayList<Llibre> llista = biblioteca.recuperarTots();
				
				for (int i = 1; i < llista.size(); i++) {
					
					biblioteca.mostrarLlibre(llista.get(i));
					System.out.println("");
					
				}
				
				
				break;
			
			case 2:
				
				System.out.println("Introduiu el identificador del llibre que voleu mostrar : ");
				identificador = sc.nextInt();
				biblioteca.mostrarLlibre(biblioteca.recuperarLlibre(identificador));
				
				break;
				
			case 3:
				
				// TODO case 3
				
				break;
				
			case 4:
				
				System.out.println("Introduiu el identificador del llibre que voleu actualitzar : ");
				identificador = sc.nextInt();
				biblioteca.actualitzaLlibre(identificador);

			default:
				
				System.out.println("Opció incorrecta");
				
				break;
				
			}
			
			
		} while (opcio != 6);
		
		sc.close();
	}

}
