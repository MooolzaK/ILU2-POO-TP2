package controleur;

import villagegaulois.Village;
import personnages.Gaulois;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		return this.village.rechercherEtalVide();
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		int numeroEtal = -1;
		if (!this.verifierIdentite(nomVendeur)) {
			//System.out.println("Je suis désolée" + nomVendeur + " mais il faut etre un habitant de notre village pour commercer ici.");
			return numeroEtal;
		}
		//System.out.println("Bonjour "+nomVendeur+" , je vais regarder si je peux vous trouver un étal.");
		if (!this.resteEtals()) {
			//System.out.println("Désolée "+ nomVendeur + " je n'ai plus d'étal qui ne soit pas occupé.");
			return numeroEtal;
		}
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		numeroEtal  = village.installerVendeur(vendeur, produit, nbProduit);
		return numeroEtal;
		
	}

	public boolean verifierIdentite(String nomVendeur) {
		return this.controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
}
