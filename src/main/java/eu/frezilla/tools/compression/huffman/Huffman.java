package eu.frezilla.tools.compression.huffman;

import java.util.HashMap;
import java.util.Map;

public final class Huffman<T extends Analyzable> {
    
    private final Analyzer<T> analyzer;
    
    public Huffman() {
        analyzer = new Analyzer<>();
    }
    
    public Map<T, Long> analyze(T[] values) {
        if (values == null) return new HashMap<>();
        else return analyzer.analyze(values);
    }
    public void createDictionnary() {
        
    }
    
    
}
