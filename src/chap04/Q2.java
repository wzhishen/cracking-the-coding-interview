package chap04;

import java.util.LinkedList;
import java.util.Stack;

public class Q2 {
    //Given a directed graph, design an algorithm to find out whether there is a route
    //between two nodes.
    
    static boolean DFSRecursive(Node n1, Node n2) {
//        if (n1 == null) return false; // XXX: unnecessary?
        if (n1 == n2) return true;
        n1.isVisited = true;
        for (Node n : n1.adjacent) {
            if (!n.isVisited) {
                if (DFSRecursive(n, n2)) // XXX: return from recursion
                    return true;
            }
        }
        return false;
    }
    
    static boolean DFSIterative(Node n1, Node n2) {
        if (n1 == n2) return true;
        Stack<Node> s = new Stack<Node>();
        n1.isVisited = true;
        s.push(n1);
        while (!s.isEmpty()) {
            Node n = s.pop();
            for (Node a : n.adjacent) {
                if (!a.isVisited) {
                    if (a == n2) return true;
                    a.isVisited = true;
                    s.push(a);
                }
            }
        }
        return false;
    }
    
    static boolean BFSIterative(Node n1, Node n2) {
        if (n1 == n2) return true;
        LinkedList<Node> q = new LinkedList<Node>();
        n1.isVisited = true;
        q.add(n1);
        while (!q.isEmpty()) {
            Node n = q.removeFirst();
            for (Node a : n.adjacent) {
                if (!a.isVisited) {
                    if (a == n2) return true;
                    a.isVisited = true;
                    q.add(a);
                }
            }
        }
        return false;
    }
    
    //----------------------------------------------
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.adjacent.add(n2);n1.adjacent.add(n3);
        n2.adjacent.add(n3);n2.adjacent.add(n4);
        n3.adjacent.add(n4);
        
        System.out.println(DFSRecursive(n2, n4));
        System.out.println(DFSIterative(n2, n4));
        System.out.println(BFSIterative(n2, n4));
        System.out.println(DFSRecursive(n2, n1));
        System.out.println(DFSIterative(n2, n1));
        System.out.println(BFSIterative(n2, n1));
    }
    
}
