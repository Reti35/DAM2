package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Libro;
import conexion.Conectar;

public class Main {

	public static void main(String[] args) {
		
		Conectar conexio = new Conectar();
		
		insertarEnBD(conexio);
		

	}

	public static ArrayList<Libro> leerCSV() {

		ArrayList<Libro> libros = new ArrayList<Libro>();

		try {

			BufferedReader bf = new BufferedReader(new FileReader("E:\\DAM2\\AD\\adp\\AE42\\AE04_T1_4_JDBC_Dades.csv"));

			String linea;

			linea = bf.readLine();
			while ((linea = bf.readLine()) != null) {

					String[] caracteristicas = linea.split(";");
					
					System.out.println(linea);

					Libro libro = new Libro();

					if(caracteristicas[0] == "") {
						
						libro.setTitol("nc");
						
					} else {
						
						libro.setTitol(caracteristicas[0]);
						
					}
					
					if(caracteristicas[1] == "") {
						
						libro.setAutor("nc");
						
					} else {
						
						libro.setAutor(caracteristicas[1]);

					}
					
					if(caracteristicas[2] == "") {
						
						libro.setAnyNaixement(0);
						
					} else {
						
						libro.setAnyNaixement(Integer.valueOf(caracteristicas[2]));

					}
					
					if (caracteristicas[3] == "") {
						
						libro.setAnyPublicacio(0);
						
					} else {
						
						libro.setAnyPublicacio(Integer.valueOf(caracteristicas[3]));
						
					}
					libro.setEditorial(caracteristicas[4]);
					libro.setNombrePagines(Integer.valueOf(caracteristicas[5]));

					libros.add(libro);

			}

			bf.close();
			
			System.out.println(libros.size());

		} catch (Exception e) {
			
			e.printStackTrace();

		}

		return libros;

	}

	public static void insertarEnBD(Conectar conexio) {

		try {

			ArrayList<Libro> llibres = leerCSV();
			
			System.out.println(llibres.size());
 
			for (int i = 0; i < llibres.size(); i++) {
				
				String titol = llibres.get(i).getTitol();
				String autor = llibres.get(i).getAutor();
				int anyNaixemen = llibres.get(i).getAnyNaixement();
				int anyPublicacio = llibres.get(i).getAnyPublicacio();
				String editorial = llibres.get(i).getEditorial();
				int nombrePagines = llibres.get(i).getNombrePagines();
				
				String sql = "INSERT INTO `libros`(`Titol`, `Autor`, `Any naixement`, `Any publicació`, `Editorial`, `Nombre de pagines`) VALUES (?,?,?,?,?,?)";
				
				conexio.ps = conexio.getConexion().prepareStatement(sql);
				
				conexio.ps.setString(1, titol);
				conexio.ps.setString(2, autor);
				conexio.ps.setInt(3, anyNaixemen);
				conexio.ps.setInt(4, anyPublicacio);
				conexio.ps.setString(5, editorial);
				conexio.ps.setInt(6, nombrePagines);
								
				conexio.ps.executeUpdate();
				
				conexio.ps.close();
				
				System.out.println("Insertado correctamente");
				
			}
			
		} catch (Exception e) {
			
			System.out.println("Error al insertar en la base de datos");
			e.printStackTrace();
			
		}
	}
	
	public static void consulta1(Conectar conexio) {
		
		try {
			
			conexio.s = conexio.getConexion().createStatement();
			String sql = "SELECT `Titol`, `Autor`, `Any publicació` FROM `libros` WHERE `Any naixement` < 1950";
			conexio.rs = conexio.s.executeQuery(sql);
			
			while (conexio.rs.next()) {
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}

}
