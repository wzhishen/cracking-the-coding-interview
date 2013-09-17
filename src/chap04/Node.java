package chap04;

import java.util.ArrayList;

public class Node {
    int value;
    boolean isVisited;
    ArrayList<Node> adjacent;
    
    public Node(int x) {
        value = x;
        isVisited = false;
        adjacent = new ArrayList<Node>();
    }
}
