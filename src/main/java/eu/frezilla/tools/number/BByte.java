package eu.frezilla.tools.number;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Data;

@Data
public final class BByte {
    
    private final String value;
    
    public BByte(byte b) {
        value = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }
    
    public BByte(String s) {
        value = Objects.requireNonNull(s, "s can not be null");
        Pattern p = Pattern.compile("[01]{8}");
        Matcher m = p.matcher(s);
        if (m.groupCount() != 1) {
            throw new IllegalArgumentException("s is not valid");    
        }
    }
    
    public byte toByte() {
        return Byte.parseByte(value, 2);
    }
}
