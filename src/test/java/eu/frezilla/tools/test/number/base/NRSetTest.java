package eu.frezilla.tools.test.number.base;

import eu.frezilla.tools.number.base.NREnum;
import eu.frezilla.tools.number.base.NRSet;
import eu.frezilla.tools.number.base.NRSetEnum;
import eu.frezilla.tools.number.base.NumericRepresentation;
import java.util.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NRSetTest {

    private void checkToNRSetAssertions(NRSet nrSet, int nrSetSize, NREnum...nrEnums) {
        Assertions.assertEquals(nrSet.size(), nrSetSize);
        Iterator<NumericRepresentation> it = nrSet.iterator();
        for (NREnum nrEnum : nrEnums) {
            Assertions.assertTrue(it.hasNext());
            NumericRepresentation numericRepresentation = it.next();
            Assertions.assertEquals(numericRepresentation, nrEnum.toNumericRepresentation());
        }
    }
    
    @Test
    @DisplayName("Test de \"l'iterator\"")
    public void testIterator() {
        NRSet nrSet = NRSetEnum.BINARY.toNRSet();
        Iterator<NumericRepresentation> it = nrSet.iterator();
        
        try { it.remove(); Assertions.fail(); } catch (IllegalStateException e) { }
        try { it.forEachRemaining(null); Assertions.fail(); } catch (NullPointerException e) { }
        
        it.hasNext();
        Assertions.assertNotNull(it.next());
        try { it.remove(); 
        System.out.println(nrSet.size()); Assertions.fail(); } catch (UnsupportedOperationException e) { }
        
        
    }
    
    @Test
    @DisplayName("Test de l'énumération NRSetEnum")
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
