package eu.frezilla.tools.compression.huffman;

import java.util.Objects;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

@Data
final class Record implements Comparable<Record> {

    private final Byte value;
    private final long weigth;

    public Record(long weight) {
        this.value = null;
        this.weigth = weight;
    }
    
    public Record(Byte value, long weight) {
        this.value = value;
        this.weigth = weight;
    }

    @Override
    public int compareTo(Record object) {
        if (object == null) {
            return Integer.MAX_VALUE;
        }
        
        int result = Long.compare(getWeigth(), object.getWeigth());
        if (result == 0) {
            result = ObjectUtils.compare(getValue(), object.getValue());
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o instanceof Record) {
            Record myRecord = (Record) o;
            return Objects.equals(value, myRecord.getValue()) && Objects.equals(weigth, myRecord.getWeigth());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, weigth);
    }

}
