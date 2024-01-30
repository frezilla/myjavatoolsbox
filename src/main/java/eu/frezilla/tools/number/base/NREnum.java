package eu.frezilla.tools.number.base;

import java.util.Objects;

/**
 * Enumération d'instances implémentant {@code NumericRepresentation}.<p>
 * 
 * L'instance associée à l'énumération est retournée via la méthode 
 * {@code NumericRepresentationEnum.toStrVal()}.
 * 
 * @see NumericRepresentation
 */
public enum NREnum {
    ZERO(0, "0"),
    ONE(1, "1"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    A(10, "A"),
    B(11, "B"),
    C(12, "C"),
    D(13, "D"),
    E(14, "E"),
    F(15, "F");
            
    private final NumericRepresentation numericRepresentation;

    private NREnum(int value, String representation) {
        this.numericRepresentation = new NumericRepresentationImpl(representation, value);
    }
    
    /**
     * Retourne l'instance unique implémentant {@code NumericRepresentation} 
     * associée à l'énumération.
     * 
     * @return Instance unique implémentant {@code NumericRepresentation}
     */
    public NumericRepresentation toNumericRepresentation() {
        return numericRepresentation;
    }
    
    /**
     * Implémentation par défaut de l'interface {@code NumericRepresentation}
     * utilisée dans l'énumération {@code NumericRepresentationEnum}.
     * 
     * @see NumericRepresentation
     * @see NREnum
     */
    private static class NumericRepresentationImpl implements NumericRepresentation {
        
        private final String representation;
        private final int value;
        
        private NumericRepresentationImpl(String representation, int value) {
            this.representation = Objects.requireNonNull(representation, "representation is null");
            this.value = value;
        }
        
        @Override
        @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
        public boolean equals(Object o) {
            return defaultEquals(o);
        }

        @Override
        public String getRepresentation() {
            return representation;
        }

        @Override
        public int getValue() {
            return value;
        }
        
        @Override
        public int hashCode() {
            return defaultHashCode();
        }
        
        @Override
        public String toString() {
            return defaultToString();
        }
        
    }
}
