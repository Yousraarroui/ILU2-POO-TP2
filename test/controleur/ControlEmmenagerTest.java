package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
    private Chef abraracourcix;
    
    @BeforeEach
    public void initialiserSituation() {
    	System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10,5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
        village.setChef(abraracourcix);
    }

	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        assertNotNull(controlEmmenager, "Constructeur renvoie null");
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bohemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bohemine"));
		assertFalse(controlEmmenager.isHabitant("Existe pas"));
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		
	}

	@Test
	void testAjouterDruide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		Gaulois gaulois = village.trouverHabitant("Panoramix");
		assertEquals(0, gaulois.getNom().compareTo("Panoramix"));
	}

	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bohemine", 3);
		Gaulois gaulois = village.trouverHabitant("Bohemine");
		assertEquals(0, gaulois.getNom().compareTo("Bohemine"));
	}

}
