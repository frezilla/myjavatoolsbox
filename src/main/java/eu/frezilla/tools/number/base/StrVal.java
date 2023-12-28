package eu.frezilla.tools.number.base;

import java.util.Objects;

/**
 * L'interface {@code StrVal} permet d'associer à une valeur entière, une chaine
 * de caractères représentant cette valeur.<p>
 * 
 * L'interface {@code StrVal} hérite de l'interface {@code Comparable}. Une 
 * méthode de comparaison par défaut est proposée; le tri s'effectue 
 * <i>"naturellement"</i> sur la valeur entière puis la représentation de la 
 * valeur. {@code null} est considéré comme inférieur à toutes valeurs 
 * définies.<p>
 * 
 * L'interface propose 3 méthodes par défaut qui peuvent être utilisées pour 
 * surcharger les méthodes :
 * <ul><li>{@code Object.equals(Object)} &#10132; {@code StrVal.defaultEquals(Object)}</li>
 * <li>{@code Object.hashCode()} &#10132; {@code StrVal.defaultHashCode()}</li>
 * <li>{@code Object.toString()} &#10132; {@code StrVal.toString()}</li></ul>
 * 
 * @see Comparable
 */
public interface StrVal extends Comparable<StrVal> {

    @Override
    default int compareTo(StrVal o) {
        if (o == null) {
            return 1;
        }
        String otherStrVal = o.getStrVal();
        int otherValue = o.getValue();

        String thisStrVal = this.getStrVal();
        int thisValue = this.getValue();

        int compare = Integer.compare(thisValue, otherValue);
        if (compare == 0) {
            if (thisStrVal == null && otherStrVal == null) {
                return 0;
            }
            if (thisStrVal != null) {
                return thisStrVal.compareTo(otherStrVal);
            }
            return -1 * otherStrVal.compareTo(thisStrVal);
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
        if (!(obj instanceof StrVal)) {
            return false;
        }
        StrVal other = (StrVal) obj;
        return Objects.equals(other.getStrVal(), this.getStrVal())
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
        return Objects.hash(getStrVal(), getValue());
    }

    /**
     * Implémentation par défaut de la méthode : {@code toString()}
     * 
     * @return Représentation de l'objet sous forme d'une chaine de caractères
     * @see Object#toString() 
     */
    default String defaultToString() {        
        return String.format("[%d - %s]", getValue(), Objects.requireNonNullElse(getStrVal(), "<null>"));
    }

    /**
     * Retourne la représentation sous forme de chaine de caractères de la
     * valeur de l'objet.
     *
     * @return Chaine de caractères représentant la valeur de l'objet
     */
    String getStrVal();

    /**
     * Retourne la valeur de l'objet.
     *
     * @return Valeur de l'objet
     */
    int getValue();
}
