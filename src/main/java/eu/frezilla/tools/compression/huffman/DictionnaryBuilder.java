package eu.frezilla.tools.compression.huffman;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import org.apache.commons.lang3.tuple.Pair;

final class DictionnaryBuilder {
    
    private DictionnaryBuilder() {
        throw new IllegalStateException("Utility class");
    }
    
    public static Map<Byte, String> build(Node rootNode) {
        Map<Byte, String> resultMap = new TreeMap<>();
        if (rootNode != null) {
            List<Pair<Byte, String>> resultList = scan(rootNode, "");
            resultList.forEach(p -> resultMap.put(p.getKey(), p.getValue()));
        }
        return resultMap;
    }
    
    private static List<Pair<Byte, String>> scan(Node rootNode, String finalValue) {
        List<Pair<Byte, String>> resultList = new ArrayList<>();
        if (rootNode.isLeaf()) {
            Record myRecord = Objects.requireNonNull(rootNode.getMyRecord(), "Record can not be null");
            myRecord.getValue();
            resultList.add(Pair.of(myRecord.getValue(), finalValue));
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
