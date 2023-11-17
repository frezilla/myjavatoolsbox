package eu.frezilla.tools.compression.huffman;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;

final class Scanner {

    private Scanner() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<Byte, Long> scan(@NonNull byte[] bytes) {
        Map<Byte, Long> map = new HashMap<>();
        for (byte b : bytes) {
            map.computeIfPresent(b, (k, val) -> (long) (val + 1));
            map.computeIfAbsent(b, k -> (long) 1);
        }

        return map;
    }

}
