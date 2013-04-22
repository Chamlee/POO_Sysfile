package filesys;

/**
 * Classe fichier qui herite d un element.
 *
 * @author Ruckebusch - De Verynas
 * @version 1.0
 * @see Element
 */

public class Fichier extends Element {
    // instance variables - replace the example below with your own
    private int taille;

    /**
     * Constructor for objects of class Fichier.
     *
     * @param nom
     * @param taille
     * @throws mesExceptions
     */

    public Fichier(String nom, int taille) throws mesExceptions {
        super(nom);

        if (taille < 0) {
            throw new mesExceptions(
                    "La taille d'un fichier doit etre superieur a 0 ");
        } else {
            this.taille = taille;
        }

    }

    /**
     * @return un entier pour connaitre la taille du fichier.
     */

    public int getTaille() {
        return taille;
    }

    /**
     * @return une chaine de caractere pour savoir de quel type est notre
     *         element. Ici un fichier.
     */

    public String getType() {
        return "Fichier";
    }

    @Override
    public String toString() {
        return super.nom+" "+taille;
    }

}
