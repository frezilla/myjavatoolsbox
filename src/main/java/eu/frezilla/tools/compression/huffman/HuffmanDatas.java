package eu.frezilla.tools.compression.huffman;

import java.util.Arrays;
import lombok.Data;
import lombok.NonNull;

@Data
public final class HuffmanDatas {
    
    private final byte[] datas;
    private final Dictionary dictionary;
    
    public HuffmanDatas(@NonNull byte[] pDatas, @NonNull Dictionary pDictionary) {
        this.datas = Arrays.copyOf(pDatas, pDatas.length);
        this.dictionary = pDictionary;
    }
    
    public byte[] getDatas() {
        return Arrays.copyOf(datas, datas.length);
    }
}
