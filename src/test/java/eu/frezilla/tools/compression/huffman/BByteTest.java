package eu.frezilla.tools.compression.huffman;

import eu.frezilla.tools.number.BByte;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BByteTest {

    @Test
    public void createInstance() {
        Assertions.assertThrows(NullPointerException.class, () -> { new BByte(null); });
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new BByte("abc"); }); 
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new BByte("01"); }); 
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new BByte("10abcdef"); });
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new BByte("010101"); });
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new BByte("0101010101"); });
        new BByte("00000000");
        new BByte("01100110");
        new BByte("11111111");
        new BByte("0000000011111111");
    }
    
    @Test
    public void toByteTest() {
        byte b = ;
        Assertions.assertTrue(
                Objects.equals(
                        new BByte("00000000").toByte(), 
                        Byte.valueOf("0")
                )
        );
        
        System.out.println(b);
    }
}
