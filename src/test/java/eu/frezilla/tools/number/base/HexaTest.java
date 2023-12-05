package eu.frezilla.tools.number.base;

import org.junit.jupiter.api.Test;

public class HexaTest {
    
    @Test
    public void testDecode() {
        Hexa.decode("F");
        System.out.println(Binary.format(Hexa.decode("FFF")));
    }
    
    @Test
    public void testEncode() {
        
    }
}
