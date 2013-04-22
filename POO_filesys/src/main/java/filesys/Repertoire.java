package filesys;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arnaud ruckebusch - Pierre de Veyrinas
 * @version 1.0
 * @see Element
 */
public class Repertoire extends Element {

    private String nom;
    private int nbElem;
    private List<Element> element = new ArrayList<Element>();
    private static final int CAPACITE_MAX = 1000;

    /**
     * Constructor for objects of class Repertoire.
     * 
     * @param nom
     * @throws mesExceptions
     */
    public Repertoire(String nom) throws mesExceptions {
        super(nom);
        nbElem = 0;
    }

    /**
     * @return le nom du repertoire.
     * 
     */
    public String getNom() {
        return super.nom;
    }

    /**
     * @return une chaine de caractere pour savoir de quel type est notre
     *         element. Ici un repertoire.
     * 
     */
    public String getType() {
        return "Repertoire";
    }

    /**
     * @param elem
     * @throws mesExceptions
     * @return true or false
     */
    public boolean ajoutElement(Element elem) throws mesExceptions {

        if (elem == null) {
            return false;
        } else if ((getTaille() + elem.getTaille()) > CAPACITE_MAX) {
            throw new mesExceptions(
                    " Le repertoire est remplit. Il ne peut contenir que "
                            + CAPACITE_MAX + " octects au maximum");

        } else if (elementDirect(elem) == true) {
            return false;
        } else if (descendantIndirect(elem) == true) {
            return false;
        } else if (elem.equals(this)) {
            return false;
        } else {
            element.add(elem);
            return true;
        }
    }

    /**
     * Récupère la taille de element.
     * 
     * @return tailleTot un entier pour connaitre la taille du repertoire
     */
    public int getTaille() {
        int tailleTot = 0;
        for (int i = 0; i < element.size(); i++) {
            tailleTot = element.get(i).getTaille() + tailleTot;
        }

        return tailleTot;
    }

    /**
     * Cherche egalite de deux elements dans un meme repertoire.
     * 
     * @param elem
     * @return test
     */
    public boolean elementDirect(Element elem) {

        boolean test = false;

        for (int i = 0; i < element.size(); i++) {
            if (element.get(i).getNom().equals(elem.getNom())) {
                test = true;
            }
        }
        return test;
    }

    /**
     * @return la liste d element
     * 
     */
    public List<Element> getElement() {
        return element;
    }

    /**
     * Cherche les descedant indirect.
     * 
     * @param rep
     * @return true or false
     */
    public boolean descendantIndirect(Element rep) {
        if (rep instanceof Repertoire) {
            List<Element> contenu = ((Repertoire) rep).element;

            for (Element item : contenu) {
                if (item.equals(this)) {
                    return true;
                } else {
                    if (item instanceof Repertoire) {
                        descendantIndirect(item);
                    }
                }
            }
        }
        return (false);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((element == null) ? 0 : element.hashCode());
        result = prime * result + nbElem;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        return result;
    }

    /**
     * La methode equal est redefini.
     * 
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Repertoire other = (Repertoire) obj;
        if (element == null) {
            if (other.element != null) {
                return false;
            }
        } else if (!element.equals(other.element)) {
            return false;
        }
        if (nbElem != other.nbElem) {
            return false;
        }
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
