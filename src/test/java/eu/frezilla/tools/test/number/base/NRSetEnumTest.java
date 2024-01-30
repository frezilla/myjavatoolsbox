package eu.frezilla.tools.test.number.base;

import eu.frezilla.tools.number.base.NREnum;
import eu.frezilla.tools.number.base.NRSet;
import eu.frezilla.tools.number.base.NRSetEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NRSetEnumTest {

    private void checkToNRSetAssertions(NRSet nrSet, int nrSetSize, NREnum...nrEnums) {
        Assertions.assertEquals(nrSet.size(), nrSetSize);
        
    }
    
    @Test
    public void testToNRSet() {
        checkToNRSetAssertions(
                NRSetEnum.BINARY.toNRSet(), 
                2, 
                NREnum.ZERO, 
                NREnum.ONE
        );
        
        checkToNRSetAssertions(
                NRSetEnum.DECIMAL.toNRSet(), 
                10, 
                NREnum.ZERO, 
                NREnum.ONE, 
                NREnum.TWO, 
                NREnum.THREE, 
                NREnum.FOUR, 
                NREnum.FIVE, 
                NREnum.SIX, 
                NREnum.SEVEN,
                NREnum.EIGHT,
                NREnum.NINE
        );
        
        checkToNRSetAssertions(
                NRSetEnum.HEXADECIMAL.toNRSet(), 
                16, 
                NREnum.ZERO, 
                NREnum.ONE,
                NREnum.TWO, 
                NREnum.THREE, 
                NREnum.FOUR, 
                NREnum.FIVE, 
                NREnum.SIX, 
                NREnum.SEVEN,
                NREnum.EIGHT,
                NREnum.NINE,
                NREnum.A,
                NREnum.B,
                NREnum.C,
                NREnum.D,
                NREnum.E,
                NREnum.F
        );
        
        checkToNRSetAssertions(
                NRSetEnum.OCTAL.toNRSet(), 
                8, 
                NREnum.ZERO, 
                NREnum.ONE, 
                NREnum.TWO, 
                NREnum.THREE, 
                NREnum.FOUR, 
                NREnum.FIVE, 
                NREnum.SIX, 
                NREnum.SEVEN
        );
        
    }
}
