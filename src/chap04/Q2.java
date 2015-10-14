package chap04;

import static helpers.Printer.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import helpers.GraphNode;

/**
 * Given a directed graph, design an algorithm to find out
 * whether there is a route between two nodes.
 */
public class Q2 {
    public static boolean DFSRecursive(GraphNode n1, GraphNode n2) {
        if (n1 == null || n2 == null) return false;
        n1.isVisited = true;
        if (n1 == n2) return true;
        for (GraphNode child : n1.adjacent) {
            if (!child.isVisited) {
                if(DFSRecursive(child, n2)) return true;
            }
        }
        return false;
    }

    public static boolean DFSIterative(GraphNode n1, GraphNode n2) {
        if (n1 == null || n2 == null) return false;
        Stack<GraphNode> stack = new Stack<GraphNode>();
        stack.push(n1);
        while(!stack.isEmpty()) {
            GraphNode n = stack.pop();
            if (!n.isVisited) {
                n.isVisited = true;
                if (n == n2) return true;
                stack.addAll(n.adjacent);
            }
        }
        return false;
    }

    public static boolean BFS(GraphNode n1, GraphNode n2) {
        if (n1 == null || n2 == null) return false;
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(n1);
        while (!queue.isEmpty()) {
            GraphNode n = queue.remove();
            if (!n.isVisited) {
                n.isVisited = true;
                if (n == n2) return true;
                queue.addAll(n.adjacent);
            }
        }
        return false;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        /*
         * 1->2
         * | /|
         * v/ |
         * v  v
         * 3->4
         */
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        n1.adjacent.add(n2);n1.adjacent.add(n3);
        n2.adjacent.add(n3);n2.adjacent.add(n4);
        n3.adjacent.add(n4);

        println(DFSRecursive(n2, n4)); resetVisited(n1, n2, n3, n4);
        println(DFSIterative(n2, n4)); resetVisited(n1, n2, n3, n4);
        println(BFS(n2, n4));          resetVisited(n1, n2, n3, n4);
        println(DFSRecursive(n4, n1)); resetVisited(n1, n2, n3, n4);
        println(DFSIterative(n4, n1)); resetVisited(n1, n2, n3, n4);
        println(BFS(n4, n1));          resetVisited(n1, n2, n3, n4);
    }

    private static void resetVisited(GraphNode... nodes) {
        for (GraphNode n : nodes) n.isVisited = false;
    }
}
