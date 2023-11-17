package eu.frezilla.tools.compression.huffman;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import lombok.NonNull;

public final class Huffman {
    
    private Huffman() {
        throw new IllegalStateException("Utility class");
    }
    
    public static void compress(@NonNull byte[] paramBytes) throws IOException {
        if (paramBytes.length == 0) {
        byte[] bytes = Arrays.copyOf(paramBytes, paramBytes.length);
        
        Map<Byte, Long> map = Scanner.scan(bytes);
        Node rootNode = TreeBuilder.build(map);
        Map<Byte, String> dictionnary = DictionnaryBuilder.build(rootNode);
        
        
        
        
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(dictionnary.get(b));
        }
        
        
        int nbBytes = sb.length()%8 + 1;
        
        new Byte()
    }
    
}
