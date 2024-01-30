package eu.frezilla.tools.compression.huffman;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import lombok.NonNull;

final class TreeBuilder {

    private TreeBuilder() {
        throw new IllegalStateException("Utility class");
    }

    public static Node build(@NonNull Map<Byte, Long> map) {
        LinkedList<Node> list = new LinkedList<>();

        map.forEach((v, w) -> list.add(new Node(v, w)));
        return build(list);
    }
    
    private static Node build(LinkedList<Node> list) {
        switch (list.size()) {
            case 0 -> {
                return null;
            }
            case 1 -> {
                return list.getFirst();
            }
            default -> {
                Collections.sort(list);
                Node firstNode = list.removeFirst();
                Node secondNode = list.removeFirst();
                Node fatherNode = new Node(firstNode, secondNode);
                list.add(fatherNode);
                return build(list);
            }       
        }
    }

}
