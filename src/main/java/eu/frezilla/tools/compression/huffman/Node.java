package eu.frezilla.tools.compression.huffman;

import java.util.Objects;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

final class Node implements Comparable<Node> {
    
    @Getter private final Node leftChild;
    @Getter private final Record myRecord;
    @Getter private final Node rightChild;
    
    public Node(byte value, long weight) {
        this.leftChild = null;
        this.rightChild = null;
        this.myRecord = new Record(value, weight);
    }
    
    public Node(Node leftChild, Node rightChild) {
        this.leftChild = Objects.requireNonNull(leftChild);
        this.rightChild = Objects.requireNonNull(rightChild);
        this.myRecord = new Record(
                getLeftChild().getMyRecord().getWeigth() 
                        + getRightChild().getMyRecord().getWeigth());
    }
    
    public boolean isLeaf() {
        return getLeftChild() == null && getRightChild() == null;
    }

    @Override
    public int compareTo(Node paramNode) {
        if (paramNode == null) {
            return Integer.MAX_VALUE;
        }
        
        int result = myRecord.compareTo(paramNode.getMyRecord());
        if (result == 0) {
            result = ObjectUtils.compare(leftChild, paramNode.getLeftChild());
        }
        if (result == 0) {
            result = ObjectUtils.compare(rightChild, paramNode.getRightChild());
        }
        return result;
    }
}
