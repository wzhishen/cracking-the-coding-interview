package chap03;

import static helpers.Printer.*;

import java.util.Stack;

/**
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks
 * of different sizes which can slide onto any tower. The puzzle starts with disks sorted
 * disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top
 * of an even larger one). You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto the next tower.
 * (3) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 */
public class Q4 {
    static class Tower {
        Stack<Integer> disks;
        int id;

        public Tower(int id) {
            this.id = id;
            this.disks = new Stack<Integer>();
        }

        public void printTower() {
            for (int disk : disks) print(disk + " ");
            println("[TOP]");
        }
    }

    public static void moveTop(Tower from, Tower to) {
        if (to.disks.isEmpty() || from.disks.peek() < to.disks.peek()) {
            printfln("Move disk %d from tower %d to tower %d",
                     from.disks.peek(), from.id, to.id);
            to.disks.push(from.disks.pop());
        } else {
            printfln("Unable to move disk %d on top of smaller disk %d from tower %d to tower %d",
                     from.disks.peek(), to.disks.peek(), from.id, to.id);
        }
    }

    public static void moveDisks(int n, Tower from, Tower to, Tower buffer) {
        if (n <= 0) return;
        moveDisks(n - 1, from, buffer, to);
        moveTop(from, to);
        moveDisks(n - 1, buffer, to, from);
    }

    public static void printTowers(Tower[] towers) {
        for (Tower t : towers) {
            print("Tower " + t.id + ": ");
            t.printTower();
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        final int DISKS_SIZE = 5;
        Tower[] towers = new Tower[3];
        for (int i = 0; i < towers.length; ++i)
            towers[i] = new Tower(i + 1);
        for (int i = DISKS_SIZE; i > 0; --i)
            towers[0].disks.push(i);
        println("BEFORE ---------------------");
        printTowers(towers);
        println("\nMOVING ---------------------");
        moveDisks(DISKS_SIZE, towers[0], towers[2], towers[1]);
        println("\nAFTER ----------------------");
        printTowers(towers);
    }
}
