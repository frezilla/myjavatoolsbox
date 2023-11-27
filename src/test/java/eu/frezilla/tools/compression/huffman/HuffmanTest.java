package eu.frezilla.tools.compression.huffman;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
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
        String msg = "Ceci est un message; je suis en train de regarder indiana jones";
        
        HuffmanDatas hDatas = Huffman.compress(msg.getBytes());
        System.out.println(hDatas.getDatas());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
