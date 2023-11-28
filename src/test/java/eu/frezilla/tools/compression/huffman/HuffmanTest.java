package eu.frezilla.tools.compression.huffman;

import eu.frezilla.tools.compression.huffman.Dictionary.Item;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class HuffmanTest {

    public HuffmanTest() {
    }


    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of compress method, of class Huffman.
     */
    @org.junit.jupiter.api.Test
    public void testCompress() throws Exception {
        String msg = "this is an example of a huffman tree";
        
        CompressResult result = Huffman.compress(msg.getBytes());
        for (Item item : result.getDictionary().getItems()) {
            
            char c = (char) item.getByteInput().shortValue();
            
            System.out.println(c + " - " + item.getValue());
        }
        
        for (byte b : result.getDatas()) {
            System.out.print(String.format("%8s", Integer.toBinaryString(b)).replace(" ", "0"));    
        }
                
    }

}
