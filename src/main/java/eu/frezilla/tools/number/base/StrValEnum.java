package eu.frezilla.tools.number.base;

import java.util.Objects;

/**
 * Enumération d'instances implémentant {@code StrVal}.<p>
 * 
 * L'instance associé à l'énumération est retournée via la méthode 
 * {@code StrValEnum.toStrVal()}.
 * 
 * @see StrVal
 */
public enum StrValEnum {
    ZERO(0, "0"),
    ONE(1, "1"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    HEIGHT(8, "8"),
    NINE(9, "9"),
    A(10, "A"),
    B(11, "B"),
    C(12, "C"),
    D(13, "D"),
    E(14, "E"),
    F(15, "F");
            
    private final StrVal strVal;

    private StrValEnum(int value, String strVal) {
        this.strVal = new StrValImpl(strVal, value);
    }
    
    /**
     * Retourne l'instance unique implémentant {@code StrVal} associée à 
     * l'énumération.
     * 
     * @return Instance unique implémentant {@code StrVal}
     */
    public StrVal toStrVal() {
        return strVal;
    }
    
    private static class StrValImpl implements StrVal {
        
        private final String strVal;
        private final int value;
        
        private StrValImpl(String strVal, int value) {
            this.strVal = Objects.requireNonNull(strVal, "strVal is null");
            this.value = value;
        }
        
        @Override
        public boolean equals(Object o) {
            return defaultEquals(o);
        }

        @Override
        public String getStrVal() {
            return strVal;
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
