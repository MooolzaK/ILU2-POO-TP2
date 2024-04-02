package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!this.controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui ! \n");
			return;
		}
		String[] donneesEtal = new String[5];
		donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
		System.out.println("Vous avez vendu "+donneesEtal[4]+" sur "+donneesEtal[3]+" "+donneesEtal[2]+".\n");
		System.out.println("Au revoir "+nomVendeur+" passez une bonne journée.");
	}

}
