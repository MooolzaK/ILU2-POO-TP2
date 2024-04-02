package controleur;

import villagegaulois.Village;
import personnages.Gaulois;
import villagegaulois.Etal;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifierIdentite(String nom) {
		return this.controlVerifierIdentite.verifierIdentite(nom);
	}

	public boolean produitPresent(String nomProduit) {
		if(village.rechercherVendeursProduit(nomProduit)==null) {
			return false;
		}
		return true;
	}
	
	public Gaulois[] vendeursProduit(String nomProduit) {
		return village.rechercherVendeursProduit(nomProduit);
	}
	public Etal donnerEtalVendeur(String nomVendeur) {
		return this.controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
	public int getQuantite(Etal etal) {
		return etal.getQuantite();
	}
	
	public int acheterProduit(String nom, int qte) {
		Etal etal = this.donnerEtalVendeur( nom);
		return etal.acheterProduit(qte);
	}
}
