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

    public static Map<Byte, Long> scan(@NonNull InputStream is) throws IOException {
        Integer data;

        Map<Byte, Long> map = new HashMap<>();
        while ((data = is.read()) != -1) {
            byte value = data.byteValue();
            map.computeIfPresent(value, (k, val) -> (long) (val + 1));
            map.computeIfAbsent(value, k -> (long) 1);
        }

        return map;
    }

}
