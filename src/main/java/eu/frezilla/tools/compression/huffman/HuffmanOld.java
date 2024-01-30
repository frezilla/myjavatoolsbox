package eu.frezilla.tools.compression.huffman;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public final class HuffmanOld {

    private HuffmanOld() {
        throw new IllegalStateException("Class utilitaire : constructeur interdit");
    }

    public static CompressResult compress(byte[] byteArray) throws IOException {
        if (Objects.requireNonNull(byteArray, "Le tableau d'octets ne doit pas être null").length == 0) {
            throw new IllegalArgumentException("Le tableau d'octets ne doit pas être vide");
        }
        
        byte[] inputBytes = Arrays.copyOf(byteArray, byteArray.length);

        Map<Byte, Long> map = Analyzer.scan(inputBytes);
        Node rootNode = TreeBuilder.build(map);
        
        Dictionary dictionary = DictionnaryBuilder.build(rootNode);
        Map<Byte, String> dictionaryMap = dictionary.toMap();
        
        StringBuilder outputSB = new StringBuilder();
        for (byte b : inputBytes) {
            outputSB.append(dictionaryMap.get(b));
        }
        String outputString = outputSB.toString();

        int outputSize = outputSB.length() / 8;
        if (outputSB.length() % 8 > 0) {
            outputSize++;
        }
        
        byte[] outputBytes = new byte[outputSize];
        int indexArray = 0;
        int index = 0;
        while (index < outputString.length()) {
            String byteValue = StringUtils.rightPad(StringUtils.substring(outputString, index, index + 8), 8, "0");
            outputBytes[indexArray] = new BigInteger(byteValue, 2).byteValue();

            index = index + 8;
            indexArray++;
        }
        return new CompressResult(outputBytes, dictionary);
    }
}