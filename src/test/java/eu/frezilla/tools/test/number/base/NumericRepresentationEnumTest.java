package eu.frezilla.tools.test.number.base;

import eu.frezilla.tools.number.base.NumericRepresentation;
import eu.frezilla.tools.number.base.NumericRepresentationEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumericRepresentationEnumTest {
    
    private void checkAsserts(NumericRepresentation numericRepresentation, int value, String representation) {
        Assertions.assertEquals(numericRepresentation.getRepresentation(), representation);
        Assertions.assertEquals(numericRepresentation.getValue(), value);
    }
    
    @Test
    @DisplayName("Test de l'énumération NumericRepresentationEnum")
    public void testToStrValSet() {
        checkAsserts(NumericRepresentationEnum.ZERO.toNumericRepresentation(), 0, "0");
        checkAsserts(NumericRepresentationEnum.ONE.toNumericRepresentation(), 1, "1");
        checkAsserts(NumericRepresentationEnum.TWO.toNumericRepresentation(), 2, "2");
        checkAsserts(NumericRepresentationEnum.THREE.toNumericRepresentation(), 3, "3");
        checkAsserts(NumericRepresentationEnum.FOUR.toNumericRepresentation(), 4, "4");
        checkAsserts(NumericRepresentationEnum.FIVE.toNumericRepresentation(), 5, "5");
        checkAsserts(NumericRepresentationEnum.SIX.toNumericRepresentation(), 6, "6");
        checkAsserts(NumericRepresentationEnum.SEVEN.toNumericRepresentation(), 7, "7");
        checkAsserts(NumericRepresentationEnum.EIGHT.toNumericRepresentation(), 8, "8");
        checkAsserts(NumericRepresentationEnum.NINE.toNumericRepresentation(), 9, "9");
        checkAsserts(NumericRepresentationEnum.A.toNumericRepresentation(), 10, "A");
        checkAsserts(NumericRepresentationEnum.B.toNumericRepresentation(), 11, "B");
        checkAsserts(NumericRepresentationEnum.C.toNumericRepresentation(), 12, "C");
        checkAsserts(NumericRepresentationEnum.D.toNumericRepresentation(), 13, "D");
        checkAsserts(NumericRepresentationEnum.E.toNumericRepresentation(), 14, "E");
        checkAsserts(NumericRepresentationEnum.F.toNumericRepresentation(), 15, "F");
    }
}
