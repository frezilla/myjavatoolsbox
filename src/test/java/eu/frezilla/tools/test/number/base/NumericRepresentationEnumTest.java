package eu.frezilla.tools.test.number.base;

import eu.frezilla.tools.number.base.NumericRepresentation;
import eu.frezilla.tools.number.base.NumericRepresentationEnum;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests de l'énumération {@code NumericRepresentationEnum} et de son 
 * implémentation par défaut de l'interface {@code NumericRepresentation}.
 * 
 * @see NumericRepresentation
 * @see NumericRepresentationEnum
 */
public class NumericRepresentationEnumTest {

    private void checkToNumericRepresentationAsserts(NumericRepresentation numericRepresentation, int value, String representation) {
        Assertions.assertEquals(numericRepresentation.getRepresentation(), representation);
        Assertions.assertEquals(numericRepresentation.getValue(), value);
    }
    
    @Test
    @DisplayName("Test de la méthode de comparaison")
    public void testCompare() {
        NumericRepresentationEnum[] array = NumericRepresentationEnum.values();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                NumericRepresentation numericRepresentation1 = array[i].toNumericRepresentation();
                NumericRepresentation numericRepresentation2 = array[j].toNumericRepresentation();

                if (i == j) {
                    Assertions.assertEquals(0, numericRepresentation1.compareTo(numericRepresentation2));
                } else {
                    Assertions.assertTrue(numericRepresentation1.compareTo(numericRepresentation2) < 0);
                    Assertions.assertTrue(numericRepresentation2.compareTo(numericRepresentation1) > 0);
                }
            }
        }
    }
    
    @Test
    @DisplayName("Test de la méthode d'égalité")
    public void testEquals() {
        NumericRepresentationEnum[] array = NumericRepresentationEnum.values();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                NumericRepresentation numericRepresentation1 = array[i].toNumericRepresentation();
                NumericRepresentation numericRepresentation2 = array[j].toNumericRepresentation();

                if (i == j) {
                    Assertions.assertTrue(numericRepresentation1.equals(numericRepresentation2));
                } else {
                    Assertions.assertFalse(numericRepresentation1.equals(numericRepresentation2));
                }
            }
        }
    }
    
    @Test
    @DisplayName("Test de la méthode de hashage")
    public void testHashCode() {
        Assertions.assertEquals(NumericRepresentationEnum.ZERO.toNumericRepresentation().hashCode(), Objects.hash(0, "0"));
        Assertions.assertEquals(NumericRepresentationEnum.ONE.toNumericRepresentation().hashCode(), Objects.hash(1, "1"));
        Assertions.assertEquals(NumericRepresentationEnum.TWO.toNumericRepresentation().hashCode(), Objects.hash(2, "2"));
        Assertions.assertEquals(NumericRepresentationEnum.THREE.toNumericRepresentation().hashCode(), Objects.hash(3, "3"));
        Assertions.assertEquals(NumericRepresentationEnum.FOUR.toNumericRepresentation().hashCode(), Objects.hash(4, "4"));
        Assertions.assertEquals(NumericRepresentationEnum.FIVE.toNumericRepresentation().hashCode(), Objects.hash(5, "5"));
        Assertions.assertEquals(NumericRepresentationEnum.SIX.toNumericRepresentation().hashCode(), Objects.hash(6, "6"));
        Assertions.assertEquals(NumericRepresentationEnum.SEVEN.toNumericRepresentation().hashCode(), Objects.hash(7, "7"));
        Assertions.assertEquals(NumericRepresentationEnum.EIGHT.toNumericRepresentation().hashCode(), Objects.hash(8, "8"));
        Assertions.assertEquals(NumericRepresentationEnum.NINE.toNumericRepresentation().hashCode(), Objects.hash(9, "9"));
        Assertions.assertEquals(NumericRepresentationEnum.A.toNumericRepresentation().hashCode(), Objects.hash(10, "A"));
        Assertions.assertEquals(NumericRepresentationEnum.B.toNumericRepresentation().hashCode(), Objects.hash(11, "B"));
        Assertions.assertEquals(NumericRepresentationEnum.C.toNumericRepresentation().hashCode(), Objects.hash(12, "C"));
        Assertions.assertEquals(NumericRepresentationEnum.D.toNumericRepresentation().hashCode(), Objects.hash(13, "D"));
        Assertions.assertEquals(NumericRepresentationEnum.E.toNumericRepresentation().hashCode(), Objects.hash(14, "E"));
        Assertions.assertEquals(NumericRepresentationEnum.F.toNumericRepresentation().hashCode(), Objects.hash(15, "F"));
    }

    @Test
    @DisplayName("Test de l'énumération NumericRepresentationEnum")
    public void testToNumericRepresentation() {
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.ZERO.toNumericRepresentation(), 0, "0");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.ONE.toNumericRepresentation(), 1, "1");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.TWO.toNumericRepresentation(), 2, "2");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.THREE.toNumericRepresentation(), 3, "3");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.FOUR.toNumericRepresentation(), 4, "4");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.FIVE.toNumericRepresentation(), 5, "5");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.SIX.toNumericRepresentation(), 6, "6");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.SEVEN.toNumericRepresentation(), 7, "7");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.EIGHT.toNumericRepresentation(), 8, "8");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.NINE.toNumericRepresentation(), 9, "9");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.A.toNumericRepresentation(), 10, "A");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.B.toNumericRepresentation(), 11, "B");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.C.toNumericRepresentation(), 12, "C");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.D.toNumericRepresentation(), 13, "D");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.E.toNumericRepresentation(), 14, "E");
        checkToNumericRepresentationAsserts(NumericRepresentationEnum.F.toNumericRepresentation(), 15, "F");
    }
    
    @Test
    @DisplayName("Test de la méthode toString")
    public void testToString() {
        Assertions.assertEquals(NumericRepresentationEnum.ZERO.toNumericRepresentation().toString(), "[0 - 0]");
        Assertions.assertEquals(NumericRepresentationEnum.ONE.toNumericRepresentation().toString(), "[1 - 1]");
        Assertions.assertEquals(NumericRepresentationEnum.TWO.toNumericRepresentation().toString(), "[2 - 2]");
        Assertions.assertEquals(NumericRepresentationEnum.THREE.toNumericRepresentation().toString(), "[3 - 3]");
        Assertions.assertEquals(NumericRepresentationEnum.FOUR.toNumericRepresentation().toString(), "[4 - 4]");
        Assertions.assertEquals(NumericRepresentationEnum.FIVE.toNumericRepresentation().toString(), "[5 - 5]");
        Assertions.assertEquals(NumericRepresentationEnum.SIX.toNumericRepresentation().toString(), "[6 - 6]");
        Assertions.assertEquals(NumericRepresentationEnum.SEVEN.toNumericRepresentation().toString(), "[7 - 7]");
        Assertions.assertEquals(NumericRepresentationEnum.EIGHT.toNumericRepresentation().toString(), "[8 - 8]");
        Assertions.assertEquals(NumericRepresentationEnum.NINE.toNumericRepresentation().toString(), "[9 - 9]");
        Assertions.assertEquals(NumericRepresentationEnum.A.toNumericRepresentation().toString(), "[10 - A]");
        Assertions.assertEquals(NumericRepresentationEnum.B.toNumericRepresentation().toString(), "[11 - B]");
        Assertions.assertEquals(NumericRepresentationEnum.C.toNumericRepresentation().toString(), "[12 - C]");
        Assertions.assertEquals(NumericRepresentationEnum.D.toNumericRepresentation().toString(), "[13 - D]");
        Assertions.assertEquals(NumericRepresentationEnum.E.toNumericRepresentation().toString(), "[14 - E]");
        Assertions.assertEquals(NumericRepresentationEnum.F.toNumericRepresentation().toString(), "[15 - F]");
    }
   
}
