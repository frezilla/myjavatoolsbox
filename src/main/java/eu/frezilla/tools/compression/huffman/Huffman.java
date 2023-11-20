package eu.frezilla.tools.compression.huffman;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import lombok.NonNull;

public final class Huffman {

    private Huffman() {
        throw new IllegalStateException("Utility class");
    }

    public static void compress(@NonNull byte[] paramBytes) throws IOException {
        if (paramBytes.length > 0) {
            byte[] bytes = Arrays.copyOf(paramBytes, paramBytes.length);

            Map<Byte, Long> map = Scanner.scan(bytes);
            Node rootNode = TreeBuilder.build(map);
            Map<Byte, String> dictionnary = DictionnaryBuilder.build(rootNode);

            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(dictionnary.get(b));
            }

            for (int i = 0; i < sb.length(); i++) {
                if (i % 8 == 0) {
                    System.out.print(" ");
                }
                System.out.print(sb.charAt(i));
            }

        }

    }
}