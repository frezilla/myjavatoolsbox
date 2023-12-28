package eu.frezilla.tools.number.base;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public final class StrValSet implements StrValCollection {
    
    private Set<StrVal> strValSet;
    
    private StrValSet(Set<StrVal> set) {
        this.strValSet = set;
    }
    
    /**
     * Retourne une nouvelle instance {@code Builder} facilitant la création 
     * d'un {@code StrValSet}.
     * 
     * @return Instance {@code Builder}
     * @see Builder
     */
    public static Builder getBuilder() {
        return new Builder();
    }
    
    /**
     * Un {@code Builder} facilite la création d'une {@code StrValSet} 
     * valide.<p>
     * 
     * Un {@code StrValSet} est valide si :
     * <ul><li>La valeur d'un {@code StrVal} est unique dans l'ensemble</li>
     * <li>La représentation de la valeur d'un {@code StrVal} est unique dans 
     * l'ensemble</li></ul>
     * 
     * @see StrValSet
     */
    public static class Builder {
                        
        private final Set<StrVal> objStrValSet;
        private final Set<String> strValSet;
        private final Set<Integer> valueSet;
        
        private Builder() {
            objStrValSet = new TreeSet<>();
            strValSet = new HashSet<>();
            valueSet = new HashSet<>();
        }
        
        /**
         * Ajoute un {@code StrVal} au futur ensemble à créer.<p>
         * 
         * Si la représentation de la valeur existe déjà et est associée à une 
         * autre valeur que celle du paramètre, une exception 
         * {@code IllegalArgumentException} est soulevée.<p>
         * 
         * Si la valeur existe déjà et est associée à une autre représentation 
         * que celle du paramètre, une exception 
         * {@code IllegalArgumentException} est soulevée.<p>
         * 
         * Si le paramètre est déjà présent dans l'ensemble, l'appel à la 
         * méthode est sans effet.
         * 
         * @param strVal {@code strVal} à ajouter au futur {@code strValSet}. Si
         * le paramètre est {@code null} ou si la méthode 
         * {@code StrVal.getStrVal()} retourn {@code null}, une exception 
         * {@code NullPointerException} est soulevée. 
         * @return Instance courante du {@code Builder}
         */
        public Builder add(StrVal strVal) {
            if (strVal == null) throw new NullPointerException("strVal parameter is null");
            String currentStrVal = Objects.requireNonNull(strVal.getStrVal(), "val representation is null");
            int currentValue = strVal.getValue();
            
            boolean containsStrValSet = strValSet.contains(currentStrVal);
            boolean containsValueSet = valueSet.contains(currentValue);
            
            if (containsStrValSet && !containsValueSet) {
                throw new IllegalArgumentException("representation already exists with another value");
            } else if (!containsStrValSet && containsValueSet) {
                throw new IllegalArgumentException("value already exists with another representation");
            } else if (!containsStrValSet) {
                strValSet.add(currentStrVal);
                objStrValSet.add(strVal);
                valueSet.add(currentValue);
            }
            
            return this;
        }
        
        /**
         * Retourne une nouvelle instance {@code StrValSet} contenant les 
         * {@code StrVal} précédemment ajoutés via le {@code Builder}.
         * 
         * @return Instance {@code StrValSet}
         */
        public StrValSet build() {
            return new StrValSet(new TreeSet<>(objStrValSet));            
        }
    }
    
}
