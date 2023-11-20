package eu.frezilla.tools.compression.huffman;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

public final class Dictionnary {
    
    private final Map<Byte, String> values;
    
    public Dictionnary() {
        values = new TreeMap<>();
    }
    
    public Set<Byte> keySet() {
        Set<Byte> treeSet = new TreeSet();
        treeSet.addAll(values.keySet());
        return treeSet;
    }
    
    public String get(Byte pByte) {
        if (pByte == null) {
            return null;
        } else {
            return values.get(pByte);
        }
    }
    
    void add(@NonNull Byte pByte, @NonNull String pValue) {
        if (StringUtils.isEmpty(pValue)) {
            
        }
    }
}
