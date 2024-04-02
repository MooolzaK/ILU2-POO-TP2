package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		int taille = controlAfficherMarche.donnerInfosMarche().length;
		if(taille==0) {
			System.out.println("Le marché est vide, revenez plus tard. \n");
			return;
		}
		int i = 0;
		System.out.println(nomAcheteur + " vous trouverez au marché : \n");
		while (i < taille) {
			System.out.println("- "+infosMarche[i]+" qui vend "+infosMarche[i+1]+" "+infosMarche[i+2]);
			i+=3;
		}
		
	}
}
