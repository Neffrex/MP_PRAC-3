package aplicacio;

import algorismes.*;

public class UsaAlgorismes {
	public static void main(String[] args) {
		try {
			System.out.println(Avid.trobarSolucio(Util.carregarLaberint()).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
