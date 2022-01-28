package algorismes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	@SuppressWarnings("resource")
	public static String[][] carregarLaberint() throws IndexOutOfBoundsException{
		String laberint[][], format[];
		int files, columnes;
		Scanner sc;
		try {
			File fl = Util.chooseFile();
			sc = new Scanner(fl);
			format = sc.nextLine().split(",");
			if (format.length!=6) throw new IndexOutOfBoundsException("hi han masses dades.");
			files=Integer.parseInt(format[0])+1;
			columnes=Integer.parseInt(format[1]);
			laberint = new String[files][columnes];
			for (int i=0; i<6;i++) {
				laberint[0][i]=format[i];
			}
			for (int i=1; i<files;i++) {
				format = sc.nextLine().split(",");
				if (format.length!=columnes) throw new IndexOutOfBoundsException("hi han masses dades.");
				for (int j=0;j<columnes;j++) {
					laberint[i][j]=format[j];
				}
			}
			sc.close();
			return laberint;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}

