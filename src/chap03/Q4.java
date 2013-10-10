package chap03;

import java.util.Stack;

public class Q4 /* class Tower */ {
    //In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
    //different sizes which can slide onto any tower. The puzzle starts with disks sorted
    //in ascending order of size from top to bottom (i.e., each disk sits on top of an
    //even larger one). You have the following constraints:
    //(1) Only one disk can be moved at a time.
    //(2) A disk is slid off the top of one tower onto the next tower.
    //(3) A disk can only be placed on top of a larger disk.
    //Write a program to move the disks from the first tower to the last using stacks.
    
    Stack<Integer> disks;
    int index;
    
    public Q4(int i) /* Tower */ {
        disks = new Stack<Integer>();
        index = i;
    }
    
    void add(int disk) {
        if (!disks.isEmpty() && disk > disks.peek())
            System.out.println("Unable to add disk "+disk+". (larger than "+disks.peek()+")");
        else
            disks.push(disk);
    }
    
    void moveTopTo(Q4 tower) {
        int top = disks.pop();
        tower.add(top);
        System.out.println("Move disk "+top+" to top of tower "+tower.index);
    }
    
    static void moveDisks(int n, Q4 src, Q4 des, Q4 buf) {
        if (n <= 0) return;//XXX
        // Step #1
        moveDisks(n - 1, src, buf, des);
        // Step #2 XXX
        src.moveTopTo(des);
        // Step #3
        moveDisks(n - 1, buf, des, src);
    }
    
    public static void main(String[] args) {
        final int DISK_NUM = 5;
        Q4[] towers = new Q4[3]; /* Tower[] */
        for (int i = 0; i < towers.length; ++i)
            towers[i] = new Q4(i); /* Tower */
        for (int i = DISK_NUM; i > 0; --i)
            towers[0].add(i);
        
        System.out.println("===== Moving disks =====");
        moveDisks(DISK_NUM, towers[0], towers[2], towers[1]);
        
        System.out.println("===== Destination tower =====");
        System.out.print("[TOP] ");
        while (!towers[2].disks.isEmpty()) {
            System.out.print(towers[2].disks.pop() + " ");
        }
    }
    
}
