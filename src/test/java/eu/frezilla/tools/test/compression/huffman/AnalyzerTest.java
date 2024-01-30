package eu.frezilla.tools.test.compression.huffman;

import eu.frezilla.tools.compression.huffman.Analyzer;
import eu.frezilla.tools.compression.huffman.Analyzer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnalyzerTest {

    @Test
    @DisplayName("Analyse d'un tableau de motifs")
    public void analyze() {
        String msg = "ceci est une chaine à tester";
        
        List<ByteAnalyzable> list = new ArrayList<>();
        for (byte b : msg.getBytes()) {
            list.add(new ByteAnalyzable(b));
        }
        
        ByteAnalyzable[] array = list.toArray(ByteAnalyzable[]::new);
        
        Analyzer<ByteAnalyzable> analyzer = new Analyzer<>();
        Map<ByteAnalyzable, Long> map = analyzer.analyze(array);
        
        
        
    }
}
