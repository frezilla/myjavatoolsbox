package eu.frezilla.tools.test.number.base;

import eu.frezilla.tools.number.base.NREnum;
import eu.frezilla.tools.number.base.NumericRepresentation;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests de l'énumération {@code NREnum} et de son 
 * implémentation par défaut de l'interface {@code NumericRepresentation}.
 * 
 * @see NumericRepresentation
 * @see NREnum
 */
public class NumericRepresentationTest {

    private void checkToNumericRepresentationAsserts(NumericRepresentation numericRepresentation, int value, String representation) {
        Assertions.assertEquals(numericRepresentation.getRepresentation(), representation);
        Assertions.assertEquals(numericRepresentation.getValue(), value);
    }
    
    @Test
    @DisplayName("Test de la méthode de comparaison")
    public void testCompare() {
        NREnum[] array = NREnum.values();
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
        NREnum[] array = NREnum.values();
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
        Assertions.assertEquals(NREnum.ZERO.toNumericRepresentation().hashCode(), Objects.hash(0, "0"));
        Assertions.assertEquals(NREnum.ONE.toNumericRepresentation().hashCode(), Objects.hash(1, "1"));
        Assertions.assertEquals(NREnum.TWO.toNumericRepresentation().hashCode(), Objects.hash(2, "2"));
        Assertions.assertEquals(NREnum.THREE.toNumericRepresentation().hashCode(), Objects.hash(3, "3"));
        Assertions.assertEquals(NREnum.FOUR.toNumericRepresentation().hashCode(), Objects.hash(4, "4"));
        Assertions.assertEquals(NREnum.FIVE.toNumericRepresentation().hashCode(), Objects.hash(5, "5"));
        Assertions.assertEquals(NREnum.SIX.toNumericRepresentation().hashCode(), Objects.hash(6, "6"));
        Assertions.assertEquals(NREnum.SEVEN.toNumericRepresentation().hashCode(), Objects.hash(7, "7"));
        Assertions.assertEquals(NREnum.EIGHT.toNumericRepresentation().hashCode(), Objects.hash(8, "8"));
        Assertions.assertEquals(NREnum.NINE.toNumericRepresentation().hashCode(), Objects.hash(9, "9"));
        Assertions.assertEquals(NREnum.A.toNumericRepresentation().hashCode(), Objects.hash(10, "A"));
        Assertions.assertEquals(NREnum.B.toNumericRepresentation().hashCode(), Objects.hash(11, "B"));
        Assertions.assertEquals(NREnum.C.toNumericRepresentation().hashCode(), Objects.hash(12, "C"));
        Assertions.assertEquals(NREnum.D.toNumericRepresentation().hashCode(), Objects.hash(13, "D"));
        Assertions.assertEquals(NREnum.E.toNumericRepresentation().hashCode(), Objects.hash(14, "E"));
        Assertions.assertEquals(NREnum.F.toNumericRepresentation().hashCode(), Objects.hash(15, "F"));
    }

    @Test
    @DisplayName("Test de l'énumération NumericRepresentationEnum")
    public void testToNumericRepresentation() {
        checkToNumericRepresentationAsserts(NREnum.ZERO.toNumericRepresentation(), 0, "0");
        checkToNumericRepresentationAsserts(NREnum.ONE.toNumericRepresentation(), 1, "1");
        checkToNumericRepresentationAsserts(NREnum.TWO.toNumericRepresentation(), 2, "2");
        checkToNumericRepresentationAsserts(NREnum.THREE.toNumericRepresentation(), 3, "3");
        checkToNumericRepresentationAsserts(NREnum.FOUR.toNumericRepresentation(), 4, "4");
        checkToNumericRepresentationAsserts(NREnum.FIVE.toNumericRepresentation(), 5, "5");
        checkToNumericRepresentationAsserts(NREnum.SIX.toNumericRepresentation(), 6, "6");
        checkToNumericRepresentationAsserts(NREnum.SEVEN.toNumericRepresentation(), 7, "7");
        checkToNumericRepresentationAsserts(NREnum.EIGHT.toNumericRepresentation(), 8, "8");
        checkToNumericRepresentationAsserts(NREnum.NINE.toNumericRepresentation(), 9, "9");
        checkToNumericRepresentationAsserts(NREnum.A.toNumericRepresentation(), 10, "A");
        checkToNumericRepresentationAsserts(NREnum.B.toNumericRepresentation(), 11, "B");
        checkToNumericRepresentationAsserts(NREnum.C.toNumericRepresentation(), 12, "C");
        checkToNumericRepresentationAsserts(NREnum.D.toNumericRepresentation(), 13, "D");
        checkToNumericRepresentationAsserts(NREnum.E.toNumericRepresentation(), 14, "E");
        checkToNumericRepresentationAsserts(NREnum.F.toNumericRepresentation(), 15, "F");
    }
    
    @Test
    @DisplayName("Test de la méthode toString")
    public void testToString() {
        Assertions.assertEquals(NREnum.ZERO.toNumericRepresentation().toString(), "[0 - 0]");
        Assertions.assertEquals(NREnum.ONE.toNumericRepresentation().toString(), "[1 - 1]");
        Assertions.assertEquals(NREnum.TWO.toNumericRepresentation().toString(), "[2 - 2]");
        Assertions.assertEquals(NREnum.THREE.toNumericRepresentation().toString(), "[3 - 3]");
        Assertions.assertEquals(NREnum.FOUR.toNumericRepresentation().toString(), "[4 - 4]");
        Assertions.assertEquals(NREnum.FIVE.toNumericRepresentation().toString(), "[5 - 5]");
        Assertions.assertEquals(NREnum.SIX.toNumericRepresentation().toString(), "[6 - 6]");
        Assertions.assertEquals(NREnum.SEVEN.toNumericRepresentation().toString(), "[7 - 7]");
        Assertions.assertEquals(NREnum.EIGHT.toNumericRepresentation().toString(), "[8 - 8]");
        Assertions.assertEquals(NREnum.NINE.toNumericRepresentation().toString(), "[9 - 9]");
        Assertions.assertEquals(NREnum.A.toNumericRepresentation().toString(), "[10 - A]");
        Assertions.assertEquals(NREnum.B.toNumericRepresentation().toString(), "[11 - B]");
        Assertions.assertEquals(NREnum.C.toNumericRepresentation().toString(), "[12 - C]");
        Assertions.assertEquals(NREnum.D.toNumericRepresentation().toString(), "[13 - D]");
        Assertions.assertEquals(NREnum.E.toNumericRepresentation().toString(), "[14 - E]");
        Assertions.assertEquals(NREnum.F.toNumericRepresentation().toString(), "[15 - F]");
    }
   
}
