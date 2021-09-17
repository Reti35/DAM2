package seccion1;

import java.io.File;
import java.io.FilenameFilter;

public class Ejercicio5 implements FilenameFilter{

	public static void main(String[] args) {
		
		File directorio = new File(args[0]);
		String extension = args[1];
		
		directorio.list();

	}

	@Override
	public boolean accept(File dir, String name) {
		
		return name.endsWith();
		
	}

}
