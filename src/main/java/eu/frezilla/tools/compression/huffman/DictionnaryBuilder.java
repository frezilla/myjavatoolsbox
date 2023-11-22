package eu.frezilla.tools.compression.huffman;

import eu.frezilla.tools.compression.huffman.Dictionary.Item;
import eu.frezilla.tools.compression.huffman.Record;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

final class DictionnaryBuilder {
    
    private DictionnaryBuilder() {
        throw new IllegalStateException("Utility class");
    }
    
    public static Dictionary build(Node rootNode) {
        Dictionary dictionary = new Dictionary();
        if (rootNode != null) {
            List<Item> resultList = scan(rootNode, "");
            resultList.forEach(item -> dictionary.add(item));
        }
        return dictionary;
    }
    
    private static List<Item> scan(Node rootNode, String finalValue) {
        List<Item> resultList = new ArrayList<>();
        if (rootNode.isLeaf()) {
            Record myRecord = Objects.requireNonNull(rootNode.getMyRecord(), "Record can not be null");
            myRecord.getValue();
            resultList.add(Item.of(myRecord.getValue(), finalValue));
        } else {
            Node leftChild = rootNode.getLeftChild();
            Node rightChild = rootNode.getRightChild();
            
            if (leftChild != null) {
                resultList.addAll(scan(leftChild, finalValue + "0"));
            }
            if (rightChild != null) {
                resultList.addAll(scan(rightChild, finalValue + "1"));
            }
        }
        return resultList;
    }
}
