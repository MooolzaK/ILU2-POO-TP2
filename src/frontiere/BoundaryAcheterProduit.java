package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;


public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;
	
	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!this.controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée "+nomAcheteur+" mais il faut être un habitant de notre village pour commercer ici.\n");
			return;
		}
		System.out.println("Quel produit voulez vous acheter ? \n");
		String produit = scan.nextLine();
		if(!this.controlAcheterProduit.produitPresent(produit)) {
			System.out.println("Désolé, personne ne vend ce produit au marché \n");
			return;
		}
		Gaulois[] vendeurs = controlAcheterProduit.vendeursProduit(produit);
		System.out.println("Chez quel commerçant voulez-vous acheter des "+produit+" ? \n");
		int nbVendeurs = vendeurs.length;
		for(int i=0;i<nbVendeurs;i++) {
			System.out.println((i+1) +" - "+vendeurs[i].getNom()+"\n");
		}
		int numVendeur = scan.nextInt() - 1;
		if((numVendeur<0)||(numVendeur>nbVendeurs))
			do {
				System.out.println("Je suis désolé mais il faut être un habitant de notre village pour commercer ici. \n");
				numVendeur = scan.nextInt() -1 ;
			}while((numVendeur<0)||(numVendeur>nbVendeurs));
		
		Etal etal = this.controlAcheterProduit.donnerEtalVendeur(vendeurs[numVendeur].getNom());
		System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+vendeurs[numVendeur].getNom()+"\n");
		System.out.println("Combien de "+produit+" voulez-vous acheter ? \n");
		int qteRestante = this.controlAcheterProduit.getQuantite(etal);
		int nbProduitAAcheter = scan.nextInt();
		if(qteRestante == 0) {
			System.out.println(nomAcheteur+" veut acheter "+nbProduitAAcheter+" "+produit+", malheureusement, il n'y en a plus \n");
		}
		else if(qteRestante<nbProduitAAcheter) {
			System.out.println(nomAcheteur+" veut acheter "+nbProduitAAcheter+" "+produit+", malheureusement, il n'y en a plus que "+qteRestante+". "+nomAcheteur+" achète tout le stock de "+vendeurs[numVendeur].getNom()+"\n");
			this.controlAcheterProduit.acheterProduit(vendeurs[numVendeur].getNom(),qteRestante);
		}
		else {
			System.out.println(nomAcheteur+" achète "+nbProduitAAcheter+" à "+vendeurs[numVendeur].getNom());
			this.controlAcheterProduit.acheterProduit(vendeurs[numVendeur].getNom(),nbProduitAAcheter);
		}
		
	}
}
