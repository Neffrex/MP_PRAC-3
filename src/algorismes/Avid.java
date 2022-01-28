package algorismes;

import java.util.LinkedList;
import algorismes.*;

public class Avid {
	public static String[] trobarSolucio(String[][] laberint,int valorActual) throws Exception {
		int files=Integer.parseInt(laberint[0][0]), columnes=Integer.parseInt(laberint[0][1]);
		String entradaX=laberint[0][3], entradaY=laberint[0][4], sortidaX=laberint[0][5], sortidaY=laberint[0][6]
				/*solucio[]=new String[files*columnes]*/;		
		//TODO
		
		
		
		
		return null;
	}
	
	//TODO
	public String avid(String[] candidats) {
		LinkedList<String> S = new LinkedList<String>();
		boolean solucio=false;
		while (!(solucions.isEmpty()) && !solucio) {
			
		}
	}

	
	public String millorOpcio(String[][] laberint, int valorActual, int x, int y) {
		int valorsCasella[] = new int[3];
		String opcions[] = {laberint[x-1][y], laberint[x][y-1], laberint[x+1][y], laberint[x][y+1]}; 
		for (int i = 0; i < 4; i++) {
			switch (opcions[i].charAt(0)) {
			case 'N':
				valorsCasella[i]=0;
			case '+':
				valorsCasella[i]+=valorEnterCasella(opcions[i]);
			case '-':
				if ((valorsCasella[i]-valorEnterCasella(opcions[i]) < 1)) valorsCasella[i]=0;
				else valorsCasella[i]-=valorEnterCasella(opcions[i]);
			case '*':
				valorsCasella[i]*=valorEnterCasella(opcions[i]);
			case '/':
				if ((valorsCasella[i]/valorEnterCasella(opcions[i]) < 1)) valorsCasella[i]=0;
				else valorsCasella[i]/=valorEnterCasella(opcions[i]);
			}
		}
		if ((valorsCasella[0]==0) && (valorsCasella[1]==0) && (valorsCasella[2]==0) && (valorsCasella[3]==0)) return null;
		return opcions[indexAmbValorMesGran(valorsCasella)];
	}
	
	
	public int valorEnterCasella(String casella) {
		String format="";
		for (int i=1; i<casella.length();i++){
			format+=casella.charAt(i);
		}
		return Integer.parseInt(format);
	}
	
	
	public int indexAmbValorMesGran(int[] valors) {
		int valorMesGran=valors[0], indexMesGran=0;
		for (int i=1;i<valors.length;i++) {
			if (valors[i]>valorMesGran) {
				valorMesGran=valors[i];
				indexMesGran=i;
			}
		}
		return indexMesGran;
	}
	
	
	public boolean esSolucio(String entradaX, String entradaY, String sortidaX, String sortidaY) {
		return (entradaX.equalsIgnoreCase(sortidaX) && entradaY.equalsIgnoreCase(sortidaY));
	}
	
	
	public boolean esFactible(String[][] laberint, int valorActual, int x, int y) {
		if (millorOpcio(laberint, valorActual, x, y) != null) {
			return true;
		}
		return false;
	}
}
