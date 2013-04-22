package filesys;

/**
 * Classe element qui regroupe les elements du systeme de fichiers.
 * 
 * @author Ruckebusch - De Veyrinas
 * @version 1.0
 */
public abstract class Element {

    protected String nom;

    /**
     * Constructor for objects of class Element.
     * 
     * @param parNom
     * @throws mesExceptions
     */
    public Element(String parNom) throws mesExceptions {

        if (parNom.equals("")) {
            throw new mesExceptions("Le nom ne doit pas etre vide");
        } else {
            nom = parNom;
        }
    }

    /**
     * Methode abstraite.
     * 
     * @return un entier pour connaitre la taille de l element.
     * 
     */
    public abstract int getTaille();

    /**
     * @return une chaine de caractere pour connaitre le nom de l element.
     * 
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return une chaine de caractere pour savoir de quel type est notre
     *         element.
     * 
     */
    public abstract String getType();

    /**
     * @return result
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        return result;
    }

    /**
     * Redefinissions de la methode equals().
     * 
     * @return true or false
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Element other = (Element) obj;
        if (nom == null) {
            if (other.nom != null) {
                return false;
            }
        } else if (!nom.equals(other.nom)) {
            return false;
        }
        return true;
    }
}
