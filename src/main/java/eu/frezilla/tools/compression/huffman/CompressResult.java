package eu.frezilla.tools.compression.huffman;

import java.util.Arrays;
import lombok.NonNull;

public final class CompressResult {
    
    private final byte[] datas;
    private final Dictionary dictionary;
    
    public CompressResult(@NonNull byte[] byteArray, @NonNull Dictionary dictionary) {
        this.datas = Arrays.copyOf(byteArray, byteArray.length);
        this.dictionary = dictionary;
    }
    
    public byte[] getDatas() {
        return Arrays.copyOf(datas, datas.length);
    }
    
    public Dictionary getDictionary() {
        return dictionary;
    }
}
