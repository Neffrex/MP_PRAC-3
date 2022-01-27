package algorismes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Util {
	
	private static JFileChooser seleccioFitxer = new JFileChooser();
	public static final boolean HIGH = true, LOW = false;
	
	public static File chooseDirectory() throws FileNotFoundException {
		seleccioFitxer.setCurrentDirectory(new File("."));
		seleccioFitxer.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (seleccioFitxer.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			return seleccioFitxer.getSelectedFile();
		throw new FileNotFoundException();
	}
	
	public static File chooseFile() throws FileNotFoundException {
		seleccioFitxer.setCurrentDirectory(new File ("."));
		seleccioFitxer.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if (seleccioFitxer.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			return seleccioFitxer.getSelectedFile();
		throw new FileNotFoundException();
	}
	
	public static long countLines(File fitxer) throws FileNotFoundException {
		Scanner sc = new Scanner(fitxer);
		long lines = sc.findAll("\n").count();
		sc.close();
		return lines;
	}
	
	/**
	 * Retorna si tots els elements d'un vector segueixen un ordre.
	 * @param a Vector que conté els elements a determinar la ordenació
	 * @param high <code>true</code> si l'ordre es de menor a major, <code>false</code> en cas contrari 
	 * @return <code>true</code> si tots els elements estàn en ordre o <code>fals</code> si no ho estàn
	 */
	public static boolean isOrdered(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i-1] > a[i]) return false;
		}
		return true;
	}
}

