package eu.frezilla.tools.test.number.base;

import eu.frezilla.tools.number.base.Binary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryTest {
    
    @Test
    @DisplayName("Mise en forme de valeurs binaires")
    public void testFormat() {
        Assertions.assertEquals("00000000", Binary.format(Byte.parseByte("0")));
        Assertions.assertEquals("00000001", Binary.format(Byte.parseByte("1")));        
        Assertions.assertEquals("00000001", Binary.format(Byte.parseByte("+1")));
        Assertions.assertEquals("00000001", Binary.format(Byte.parseByte("+1")));
        Assertions.assertEquals("00001010", Binary.format(Byte.parseByte("10")));
        Assertions.assertEquals("11111111", Binary.format(Byte.parseByte("-1")));
        Assertions.assertEquals("11110110", Binary.format(Byte.parseByte("-10")));
    }
}
