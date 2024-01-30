package eu.frezilla.tools.number.base;

import java.util.Objects;

/**
 * L'interface {@code NumericRepresentation} permet d'associer à une valeur 
 * entière, une chaine de caractères représentant cette valeur.<p>
 * 
 * L'interface {@code NumericRepresentation} hérite de l'interface 
 * {@code Comparable}. Une méthode de comparaison par défaut est proposée; le 
 * tri s'effectue <i>"naturellement"</i> sur la valeur entière puis la 
 * représentation de la valeur. {@code null} est considéré comme inférieur à 
 * une valeur définie.<p>
 * 
 * L'interface propose 3 méthodes par défaut qui peuvent être utilisées pour 
 * surcharger les méthodes :
 * <ul><li>{@code Object.equals(Object)} &#10132; {@code NumericRepresentation.defaultEquals(Object)}</li>
 * <li>{@code Object.hashCode()} &#10132; {@code NumericRepresentation.defaultHashCode()}</li>
 * <li>{@code Object.toString()} &#10132; {@code NumericRepresentation.toString()}</li></ul>
 * 
 * @see Comparable
 */
public interface NumericRepresentation extends Comparable<NumericRepresentation> {

    @Override
    default int compareTo(NumericRepresentation o) {
        if (o == null) {
            return 1;
        }
        String otherRepresentation = o.getRepresentation();
        int otherValue = o.getValue();

        String thisRepresentation = this.getRepresentation();
        int thisValue = this.getValue();

        int compare = Integer.compare(thisValue, otherValue);
        if (compare == 0) {
            if (thisRepresentation == null && otherRepresentation == null) {
                return 0;
            }
            if (thisRepresentation != null) {
                return thisRepresentation.compareTo(otherRepresentation);
            }
            return -1 * otherRepresentation.compareTo(thisRepresentation);
        } else {
            return compare;
        }
    }

    /**
     * Implémentation par défaut de la méthode de test d'égalité ({@code equals})
     *
     * @param obj l'objet avec lequel l'égalité doit être testée
     * @return {@code true} si l'objet est égal à l'objet passé en paramètre,
     * {@code false} sinon
     * @see Object#equals(java.lang.Object)
     */
    default boolean defaultEquals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NumericRepresentation)) {
            return false;
        }
        NumericRepresentation other = (NumericRepresentation) obj;
        return Objects.equals(other.getRepresentation(), this.getRepresentation())
                && Objects.equals(other.getValue(), this.getValue());
    }

    /**
     * Implémentation par défaut de la méthode de hachage : 
     * {@code Object#hashCode()}
     *
     * @return la valeur du code de hachage pour l'objet
     * @see Object#hashCode()
     */
    default int defaultHashCode() {
        return Objects.hash(getRepresentation(), getValue());
    }

    /**
     * Implémentation par défaut de la méthode : {@code toString()}
     * 
     * @return Représentation de l'objet sous forme d'une chaine de caractères
     * @see Object#toString() 
     */
    default String defaultToString() {        
        return String.format("[%d - %s]", getValue(), Objects.requireNonNullElse(getRepresentation(), "<null>"));
    }

    /**
     * Retourne la représentation sous forme de chaine de caractères de la
     * valeur de l'objet.
     *
     * @return Chaine de caractères représentant la valeur de l'objet
     */
    String getRepresentation();

    /**
     * Retourne la valeur de l'objet.
     *
     * @return Valeur de l'objet
     */
    int getValue();
}
