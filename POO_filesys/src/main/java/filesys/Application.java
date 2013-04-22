package filesys;

/**
 * enumeration Application pour lancer le programme de gestion de fichiers.
 * 
 * @author Ruckebusch - De Verynas
 * @version 1.0
 */

enum Application {

    /**
     * Variable enumeration.
     */
    ENVIRONNEMENT;

    /**
     * Methode d execution utilisant les methodes du code.
     * 
     * @param args
     * @throws mesExceptions
     */
    public void run(String[] args) throws mesExceptions {

        Repertoire racine = new Repertoire("racine");
        Repertoire sousdossier = new Repertoire("repertoire2");
        Repertoire sousdossier2 = new Repertoire("repertoire3");
        int taille1 = 100;
        int taille2 = 20;
        int taille3 = 150;
        Fichier fic1 = new Fichier("fichier1", taille1);
        Fichier fic2 = new Fichier("fichier2", taille2);
        Fichier fic3 = new Fichier("fichier3", taille3);

        racine.ajoutElement(sousdossier);
        sousdossier.ajoutElement(fic2);
        sousdossier.ajoutElement(sousdossier2);
        sousdossier2.ajoutElement(fic3);

        racine.ajoutElement(fic1);

        System.out.println(fic1.toString());
        System.out.println(fic2.toString());

        System.out.println(racine.getTaille());
        System.out.println(sousdossier.getTaille());
    }

    /**
     * Methode principale.
     * 
     * @param args
     * @throws mesExceptions
     */
    public static void main(String[] args) throws mesExceptions {
        ENVIRONNEMENT.run(args);
    }

}
