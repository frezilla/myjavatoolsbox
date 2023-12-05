package eu.frezilla.tools.number.base;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class Binary {
    
    public static String format(byte b) {
        return String.format(
                "%8s", 
                Integer
                        .toBinaryString(b & 0xFF)
                        .replace(' ', '0')
        );
    }
    
    public static String format(byte[] byteArray) {
        StringBuilder value = new StringBuilder();
        
        for (byte b : byteArray) {
            value.append(format(b)).append(" ");
        }
        
        int nbChars = value.length();
        if (nbChars == 0) {
            return "";
        } else {
            return value.substring(0, nbChars - 1);
        }
    }
    
}
