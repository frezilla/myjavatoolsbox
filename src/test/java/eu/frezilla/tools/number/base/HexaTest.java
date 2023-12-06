package eu.frezilla.tools.number.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HexaTest {
    
    @Test
    public void testEncodeAndDecode() {
        String value = "FFF0";
        byte[] byteArray = Hexa.decode(value);
        Assertions.assertEquals(2, byteArray.length);
        Assertions.assertEquals(
                "11111111 11110000", 
                Binary.format(byteArray)
                );
        Assertions.assertEquals(value, new String(Hexa.encode(byteArray)));
        
        value = "29A";
        byteArray = Hexa.decode(value);
        Assertions.assertEquals(2, byteArray.length);
        Assertions.assertEquals(
                "00000010 10011010",
                Binary.format(byteArray)
                );
        Assertions.assertEquals("0" + value, new String(Hexa.encode(byteArray)));
    }
}
