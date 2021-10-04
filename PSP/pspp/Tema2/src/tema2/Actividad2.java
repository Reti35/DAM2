package tema2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Actividad2 {

	public static void main(String[] args) {

		Actividad2 lanzador = new Actividad2();

		lanzador.ejecutarSuma(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
		lanzador.ejecutarSuma(Integer.valueOf(args[2]), Integer.valueOf(args[3]));
		
	}

	public void ejecutarSuma(Integer num1, Integer num2) {

		String clase = "tema2.Actividad1";

		try {

			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			System.out.println(classpath);
			String className = clase;

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(num1.toString());
			command.add(num2.toString());

			ProcessBuilder builder = new ProcessBuilder(command);
			Process proceso = builder.inheritIO().start();

			System.out.println(proceso.exitValue());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
