package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!this.controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut etre un habitant de notre village pour commercer ici.");
			return ;
		}
		System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux vous trouver un étal.");
		if (!this.controlPrendreEtal.resteEtals()) {
			System.out.println("Désolée "+ nomVendeur + " je n'ai plus d'étal qui ne soit pas occupé.");
			return;
		}
		this.installerVendeur(nomVendeur);
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
		System.out.println("C'est parfait, il me reste un étal pour vous ! \n");
		System.out.println("Il me faudrait quelques renseignements : \n");
		System.out.println("Quel produit souhaitez-vous vendre ? \n");
		String produit= scan.next();
		System.out.println("Combien souhaitez-vous en vendre ? \n");
		int quantite = Clavier.entrerEntier("");
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);
		if(numEtal !=-1) {
			numEtal+=1; //Sinon on est à l'étal 0 ):
			System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'étal n° "+numEtal+"\n");
		}
	}
}
