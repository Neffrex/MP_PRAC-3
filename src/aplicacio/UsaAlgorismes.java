package aplicacio;

import algorismes.*;

public class UsaAlgorismes {
	
	public static void main(String[] args) {
		String[][] laberint = Util.carregarLaberint();
		//suposem que sempre comencem per una casella amb una suma:
		int valorActual=Integer.parseInt(laberint[Integer.parseInt(laberint[0][2])][Integer.parseInt(laberint[0][3])]);
		try {
			System.out.println("hola"/*Avid.trobarSolucio(Util.carregarLaberint()).toString()*/);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
