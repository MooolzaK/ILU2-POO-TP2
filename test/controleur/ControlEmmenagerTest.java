//assertEquals
package controleur;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;

import villagegaulois.Village;

import villagegaulois.Village;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleur.ControlEmmenager;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;	
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager, "Constructeur ne renvoie pas null");
	}
	
	@Test
	public void testAjouterDruide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		Druide druide = new Druide(nom, force, effetPotionMin, effetPotionMax);
		village.ajouterHabitant(druide);

	}
	
	@Test
	public void testAjouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		Gaulois gaulois = new Gaulois(nom, force);
		village.ajouterHabitant(gaulois);
	}

	@Test
	public boolean testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);

	}
}