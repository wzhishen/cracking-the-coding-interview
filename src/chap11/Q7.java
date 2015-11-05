package chap11;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A circus is designing a tower routine consisting of people
 * standing atop one another's shoulders. For practical and
 * aesthetic reasons, each person must be both shorter and
 * lighter than the person below him or her. Given the heights
 * and weights of each person in the circus, write a method
 * to compute the largest possible number of people in such
 * a tower.
 *
 * EXAMPLE
 * Input (height, weight):
 * (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 * Output:
 * The longest tower is length 6 and includes from top to bottom:
 * (56, 90) (60,95) (65, 100) (68, 110) (70, 150) (75, 190)
 */
public class Q7 {
    //treat it as a box-stacking problem
    public static ArrayList<Person> findHighestTower(List<Person> persons) {
        if (persons == null) return null;
        return findHighestTower(persons, null);
    }

    private static ArrayList<Person> findHighestTower(List<Person> persons, Person bottom) {
        int maxNum = 0;
        ArrayList<Person> maxTower = null;
        for (Person p : persons) {
            if (p.canStandAbove(bottom)) {
                ArrayList<Person> tower = findHighestTower(persons, p);
                int num = tower.size();
                if (num > maxNum) {
                    maxNum = num;
                    maxTower = tower;
                }
            }
        }
        if (maxTower == null) maxTower = new ArrayList<Person>();
        if (bottom != null) maxTower.add(bottom);
        return new ArrayList<Person>(maxTower);
    }

    //treat it as a longest-increasing-subsequence (LIS) problem
    public static ArrayList<Person> findHighestTower2(List<Person> persons) {
        if (persons == null) return null;
        Collections.sort(persons);

        ArrayList<Person>[] solutions = new ArrayList[persons.size()];
        getLIS(persons, solutions, 0);

        ArrayList<Person> bestSolution = new ArrayList<Person>();
        for (ArrayList<Person> solution : solutions) {
            if (solution.size() > bestSolution.size())
                bestSolution = solution;
        }
        return bestSolution;
    }

    private static void getLIS(List<Person> persons, ArrayList<Person>[] solutions, int index) {
        if (index > persons.size() - 1) return;
        ArrayList<Person> bestSolution = new ArrayList<Person>();
        Person current = persons.get(index);
        for (int i = 0; i < index; ++i) {
            if (persons.get(i).weight < current.weight) {
                if (solutions[i] != null & solutions[i].size() > bestSolution.size()) {
                    bestSolution = solutions[i];
                }
            }
        }
        ArrayList<Person> newSolution = new ArrayList<Person>(bestSolution);
        newSolution.add(current);
        solutions[index] = newSolution;
        getLIS(persons, solutions, index + 1);
    }

    private static class Person implements Comparable<Object> {
        int height, weight;
        public Person(int h, int w) {
            height = h;
            weight = w;
        }
        private boolean canStandAbove(Person that) {
            return that == null ||
                   (height < that.height &&
                   weight < that.weight);
        }
        public String toString() {
            return "(" + height + ", " + weight + ")";
        }
        public int compareTo(Object o) {
            Person that = (Person) o;
            return height != that.height ?
                   ((Integer) height).compareTo(that.height) :
                   ((Integer) weight).compareTo(that.weight);
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        Person[] persons = {
            new Person(56,94),
            new Person(60,95),
            new Person(65,100),
            new Person(68,93),
            new Person(70,150),
            new Person(75,200),
            new Person(75,100),
            new Person(76,190),
            new Person(76,220),
        };
        List<Person> list = Arrays.asList(persons);
        Collections.shuffle(list);
        println(findHighestTower(list));
        println(findHighestTower2(list));
    }
}
