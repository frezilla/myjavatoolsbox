package eu.frezilla.tools.compression.huffman;

import eu.frezilla.tools.number.BByte;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

public final class Huffman {

    private Huffman() {
        throw new IllegalStateException("Utility class");
    }

    public static HuffmanDatas compress(@NonNull byte[] paramBytes) throws IOException {
        if (paramBytes.length > 0) {
            byte[] inputBytes = Arrays.copyOf(paramBytes, paramBytes.length);

            Map<Byte, Long> map = Scanner.scan(inputBytes);
            Node rootNode = TreeBuilder.build(map);
            Dictionary dictionary = DictionnaryBuilder.build(rootNode);
            
            StringBuilder outputSB = new StringBuilder();
            Map<Byte, String> dictionaryMap = dictionary.toMap();
            for (byte b : inputBytes) {
                outputSB.append(dictionaryMap.get(b));
            }
            String outputString = outputSB.toString();
            
            byte[] outputBytes = new byte[(int) (outputSB.length() / 8) + 1];
            int indexArray = 0;
            int indexOutputString = 0;
            while (indexOutputString < outputString.length()) {
                String byteValue = 
                        StringUtils.rightPad(
                                StringUtils.substring(outputString, indexOutputString, indexOutputString + 8),
                                8,
                                "0"
                        );
                outputBytes[indexArray] = new BByte(byteValue).toByte();
                
                indexOutputString = indexOutputString + 8;
                indexArray++;
            }
            
        }

    }
}