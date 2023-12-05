package eu.frezilla.tools.number.base;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Hexa {
    
    private static final char[] HEXVALUES = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    
    public static byte[] decode(CharSequence charSequence) {
        if (charSequence == null) return new byte[0];
        
        final int nbChars = charSequence.length();
        if (nbChars == 0) return new byte[0];
        
        int sequenceIndex = 0;
        int arrayIndex = 0;
        byte[] resultArray;
        
        if (nbChars%2 != 0) {
            resultArray = new byte[(nbChars + 1) / 2];
            
            int msb = Character.digit('0', 16);
            int lsb = toDigit(charSequence, sequenceIndex);
            
            resultArray[arrayIndex++] = (byte) ((msb << 4) | lsb);
            sequenceIndex++;
        } else {
            resultArray = new byte[nbChars/2];
        }
        
        while (sequenceIndex < nbChars) {
            int msb = toDigit(charSequence, sequenceIndex);
            int lsb = toDigit(charSequence, sequenceIndex + 1);
            
            resultArray[arrayIndex++] = (byte) ((msb << 4) | lsb);
            
            sequenceIndex = sequenceIndex + 2;
        }
        
        return resultArray;
    }
    
    public static char[] encode(byte[] byteArray) {
        if (byteArray == null) return new char[0];
        
        final int nbBytes = byteArray.length;
        char[] resultArray = new char[2 * nbBytes];
        
        int i = 0; 
        int j = 0;
        while (i < nbBytes) {
            resultArray[j++] = HEXVALUES[(0xF0 & byteArray[i]) >>> 4];
            resultArray[j++] = HEXVALUES[(0x0F & byteArray[i])];
            i++;
        }
        return resultArray;
    }

    private static int toDigit(CharSequence charSequence, int index) {
        int value = Character.digit(charSequence.charAt(index), 16);
        
        if (value < 0) {
            throw new IllegalArgumentException("Caractère non hexadécimal détecté à la position " + (index + 1) + " ou " + (index + 2));
        }
        
        return value;
    }
}
