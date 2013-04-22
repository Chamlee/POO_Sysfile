package filesys;

import junit.framework.Assert;

import org.junit.Test;

public class RepertoireTests {

	
	@Test
	public void testNom() throws mesExceptions {
		String nom = "dossier";
		Repertoire rep = new Repertoire(nom);
		Assert.assertEquals(nom, rep.getNom());
	}

	@Test
	public void testAjoutRepDansRep() throws mesExceptions {
		Repertoire racine = new Repertoire("racine");
		Repertoire sousdossier = new Repertoire("repertoire2");
		// Assert.assertEquals(nom, rep.getNom());
		Assert.assertNotSame(racine, sousdossier);
		racine.ajoutElement(sousdossier);
	}


	@Test
	public void testTaille() throws mesExceptions {
		String nom = "fic1";
		int taille = 10;
		Fichier fic = new Fichier(nom, taille);
		Assert.assertEquals(taille, fic.getTaille());
	}

	@Test
	public void testNomDansRep() throws mesExceptions {
		
		Repertoire racine = new Repertoire("repertoire1");
		Fichier fic1 = new Fichier("fichier1", 100);
		Fichier fic2 = new Fichier("fichier1", 20);
		
		racine.ajoutElement(fic1);
		
		Assert.assertFalse(racine.ajoutElement(fic2));
		
		
	}
	
	
	@Test
	public void testTailleArbo() throws mesExceptions {

		Repertoire racine = new Repertoire("repertoire1");
		Repertoire sousdossier = new Repertoire("repertoire2");
		Fichier fic1 = new Fichier("fichier1", 100);
		Fichier fic2 = new Fichier("fichier2", 20);
		
		racine.ajoutElement(sousdossier);
		sousdossier.ajoutElement(fic2);
		racine.ajoutElement(fic1);
		
		Assert.assertEquals(120, racine.getTaille());
	}
	
	
	@Test
	public void testRepIndirect() throws mesExceptions {
		Repertoire racine = new Repertoire("repertoire1");
		Repertoire sousdossier = new Repertoire("repertoire2");
		racine.ajoutElement(sousdossier);

		Assert.assertFalse(sousdossier.ajoutElement(racine));
	}
	
	@Test
	public void testAjoutObjet() throws mesExceptions {

		Repertoire racine = new Repertoire("rep1");
		
		Assert.assertFalse(racine.ajoutElement(racine));
	}
	
	@Test
	public void referenceNulle() throws mesExceptions {
		
		Repertoire racine = new Repertoire("rep1");
		Fichier fic1 = null;
		Assert.assertFalse(racine.ajoutElement(fic1));
	}

}
