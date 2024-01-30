package eu.frezilla.tools.number.base;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class NRSet implements NRCollection {
    
    private final Map<String, NumericRepresentation> nrByRepresentationMap;
    private final Map<Integer, NumericRepresentation> nrByValueMap;
    private final int size;
    
    private NRSet(Set<NumericRepresentation> set) {
        this.nrByRepresentationMap = set.stream().collect(Collectors.toMap(NumericRepresentation::getRepresentation, Function.identity()));
        this.nrByValueMap = set.stream().collect(Collectors.toMap(NumericRepresentation::getValue, Function.identity()));
    }
    
    /**
     * Retourne une nouvelle instance {@code Builder} facilitant la création 
     * d'un {@code NRSet}.
     * 
     * @return Instance {@code Builder}
     * @see Builder
     */
    public static Builder getBuilder() {
        return new Builder();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<NumericRepresentation> iterator() {
        this.nrByRepresentationMap.values().iterator().re
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        return size;
    }
    
    /**
     * Un {@code Builder} facilite la création d'une {@code NRSet} valide.<p>
     * 
     * Un {@code NRSet} est valide si :
     * <ul><li>La valeur d'un {@code NumberRepresentation} est unique dans 
     * l'ensemble</li>
     * <li>La représentation de la valeur d'un {@code NumberRepresentation } est 
     * unique dans l'ensemble</li></ul>
     * 
     * @see NRSet
     */
    public static class Builder {
                        
        private final Set<NumericRepresentation> objNRSet;
        private final Set<String> representationSet;
        private final Set<Integer> valueSet;
        
        private Builder() {
            objNRSet = new TreeSet<>();
            representationSet = new HashSet<>();
            valueSet = new HashSet<>();
        }
        
        /**
         * Ajoute un {@code NumberRepresentation} au futur ensemble à créer.<p>
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
         * @param numericRepresentation {@code NumericRepresentation} à ajouter 
         * au futur {@code NRSet}. Si le paramètre est {@code null} ou si la 
         * méthode {@code NumericRepresentation.getRepresentation()} retourne 
         * {@code null}, une exception {@code NullPointerException} est 
         * soulevée.
         * 
         * @return Instance courante du {@code Builder}
         * @see NumericRepresentation
         */
        public Builder add(NumericRepresentation numericRepresentation) {
            if (numericRepresentation == null) throw new NullPointerException("numericRepresentation parameter is null");
            String currentRepresentation = Objects.requireNonNull(numericRepresentation.getRepresentation(), "representation is null");
            int currentValue = numericRepresentation.getValue();
            
            boolean containsRepresentation = representationSet.contains(currentRepresentation);
            boolean containsValue = valueSet.contains(currentValue);
            
            if (containsRepresentation && !containsValue) {
                throw new IllegalArgumentException("representation already exists with another value");
            } else if (!containsRepresentation && containsValue) {
                throw new IllegalArgumentException("value already exists with another representation");
            } else if (!containsRepresentation) {
                representationSet.add(currentRepresentation);
                objNRSet.add(numericRepresentation);
                valueSet.add(currentValue);
            }
            
            return this;
        }
        
        /**
         * Retourne une nouvelle instance {@code NRSet} contenant les 
         * {@code NumericRepresentation} précédemment ajoutés via le 
         * {@code Builder}.
         * 
         * @return Instance {@code NRSet}
         */
        public NRSet build() {
            return new NRSet(new TreeSet<>(objNRSet));            
        }
    }
    
}
