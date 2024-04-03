package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	
	
	@BeforeEach
	public void init() {
		System.out.println("Init..");
		village = new Village("le village sans nom", 10,5);
		abraracourcix = new Chef("Abraracourcix", 10 , village);
		village.setChef(abraracourcix);
		
	}
	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite);
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		Gaulois asterix = new Gaulois("Asterix",3);
		assertFalse(controlVerifierIdentite.verifierIdentite("Asterix"));
		village.ajouterHabitant(asterix);
		assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"));
	}

}
