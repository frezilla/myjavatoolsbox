package eu.frezilla.tools.compression.huffman;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NonNull;

public final class Dictionary {

    private final Set<Byte> byteInputSet;
    private final Set<Item> itemSet;

    public Dictionary() {
        byteInputSet = new TreeSet<>();
        itemSet = new TreeSet<>();
    }

    public boolean add(@NonNull Item item) {
        if (byteInputSet.contains(item.getByteInput())) {
            return false;
        }
        byteInputSet.add(item.getByteInput());
        itemSet.add(item);
        return true;
    }
    
    public void clear() {
        byteInputSet.clear();
        itemSet.clear();
    }
    
    public Item[] getItems() {
        Item[] array = new Item[itemSet.size()];
        return itemSet.toArray(array);
    }

    public boolean remove(Item item) {
        if (item != null && byteInputSet.contains(item.getByteInput()) && itemSet.contains(item)) {
            return byteInputSet.remove(item.getByteInput())
                    && itemSet.remove(item);
        }
        return false;
    }
    
    protected Map<Byte, String> toMap() {
        return itemSet.stream().collect(Collectors.toMap(Item::getByteInput, Item::getValue));
    }

    @Getter
    public static final class Item implements Comparable<Item> {

        private final Byte byteInput;
        private final String value;

        private Item(@NonNull Byte byteInput, @NonNull String value) {
            this.byteInput = byteInput;
            this.value = value;
        }

        public static Item of(Byte byteInput, String value) {
            return new Item(byteInput, value);
        }

        @Override
        public int compareTo(Item o) {
            if (o == null) {
                return Integer.MAX_VALUE;
            }

            int compareResult = byteInput.compareTo(o.getByteInput());
            if (compareResult == 0) {
                compareResult = value.compareTo(o.getValue());
            }

            return compareResult;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (o instanceof Item) {
                Item oItem = (Item) o;
                return Objects.equals(byteInput, oItem.getByteInput()) && Objects.equals(value, oItem.getValue());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(byteInput, value);
        }
    }
}
