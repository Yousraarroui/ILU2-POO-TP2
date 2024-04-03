package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
    private Chef abraracourcix;
    private ControlVerifierIdentite controlVerifierIdentite;
    
    @BeforeEach
    public void initialiserSituation() {
    	System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10,1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
        village.setChef(abraracourcix);
        
    }
	
	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		 assertNotNull(controlPrendreEtal);
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertTrue(controlPrendreEtal.resteEtals());
		Gaulois asterix = new Gaulois("Asterix", 3);
		village.installerVendeur(asterix, "fleurs", 10);
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertEquals(controlPrendreEtal.prendreEtal(null, null, 0));
	}

	@Test
	void testVerifierIdentite() {
		
	}

}
