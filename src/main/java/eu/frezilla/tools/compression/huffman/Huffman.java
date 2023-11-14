package eu.frezilla.tools.compression.huffman;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class Huffman {
    
    private Huffman() {
        throw new IllegalStateException("Utility class");
    }
    
    public static void compress(InputStream is) throws IOException {
        Map<Byte, Long> map = Scanner.scan(is);
        Node rootNode = TreeBuilder.build(map);
        Map<Byte, String> dictionnary = DictionnaryBuilder.build(rootNode);
        System.out.println(dictionnary);
       
        
    }
    
}
