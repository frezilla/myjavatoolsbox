package eu.frezilla.tools.test.compression.huffman;

import eu.frezilla.tools.compression.huffman.Analyzable;
import eu.frezilla.tools.compression.huffman.Analyzable;
import java.util.Objects;
import lombok.Data;

@Data
public class ByteAnalyzable implements Analyzable<ByteAnalyzable> {
    
    private final Byte value;
    
    public ByteAnalyzable(Byte value) {
        this.value = Objects.requireNonNull(value, "le paramètre value est null");
    }

    @Override
    public int compareTo(ByteAnalyzable o) {
        if (o == null) return Integer.MAX_VALUE;
        return value.compareTo(o.getValue());
    }

}
