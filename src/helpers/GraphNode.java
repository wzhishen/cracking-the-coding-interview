package helpers;

import java.util.ArrayList;

public class GraphNode {
    public int value;
    public boolean isVisited;
    public ArrayList<GraphNode> adjacent;

    public GraphNode(int x) {
        value = x;
        isVisited = false;
        adjacent = new ArrayList<GraphNode>();
    }
}
