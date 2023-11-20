package eu.frezilla.tools.compression.huffman;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

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
        String msg = "Ceci est un message; je suis en train de regarder indiana jones";
        
        Huffman.compress(msg.getBytes());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
