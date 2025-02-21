/*
 * *** Dorsa Valipourkarimi / COMP 272 002 ***
 *
 * This java file contains several simple tree problems that need to be
 * codified. These routines  must use the TreeMap and TreeSet library
 * classes from the Java Collection Framework.
 *
 */

import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

public class TreeProblems {

  /**
   * Method different()
   *
   * Given two TreeSets of integers, return a TreeSet containing all elements
   * that are NOT in both sets. In other words, return a TreeSet of all the
   * elements that are in one set but not the other.
   */

  public static Set<Integer> different(Set<Integer> setA, Set<Integer> setB) {
    // This can be done numerous ways, but once such will only that
    // *several* lines of code. Hint: create two temporary TreeSets and utilize the
    // methods retainAll(), addAll(), and removeAll(). But in the end, get something
    // to work.

    // **Note** Essentialy difference = (A-B) + (B-A) = (A Union B) - (A
    // Intersection B)
    // Created two temporary tree sets initialized to Set A and Set B
    Set<Integer> tempA = new TreeSet<>(setA);
    Set<Integer> tempB = new TreeSet<>(setB);

    // Removing the common elements between two sets/the intersection of elements
    tempA.removeAll(setB); // A-B
    tempB.removeAll(setA); // B-A

    // Join the two modified set
    tempA.addAll(tempB); // (A-B) + (B-A)

    // Return the difference set
    return tempA;

  } // Method different()

  /**
   * Method removeEven()
   *
   * Given a treeMap with the key as an integer, and the value as a String,
   * remove all <key, value> pairs where the key is even.
   */

  public static void removeEven(Map<Integer, String> treeMap) {
    // A MUCH MUCH MUCH faster way to do it(only if I knew the syntx sooner):
    // The removeIf() method iterates through the collection (On it own) and removes
    // all elements where the key value Integer is even
    // Code:
    // treeMap.entrySet().removeIf(entry -> entry.getKey()%2 == 0);

    // Create an iterator to iterate over the entries of the TreeMap
    Iterator<Map.Entry<Integer, String>> i = treeMap.entrySet().iterator();

    // Iterate through the map while there is a next Node
    while (i.hasNext()) {
      // Get the <key, value> pair from the map
      Map.Entry<Integer, String> entery = i.next();
      if (entery.getKey() % 2 == 0) { // Check if the key is even
        i.remove(); // Remove it
      }
    }
  } // Method removeEven()

  /**
   * Method treesEqual()
   *
   * Given two treeMaps, each with the key as an integer, and the value as a
   * String,
   * return a boolean value indicating if the two trees are equal or not.
   */

  public boolean treesEqual(Map<Integer, String> tree1, Map<Integer, String> tree2) {

     return tree1.equals(tree2); // Return whether the trees are equal or not

    // I know return statement above already passes the test but it feels too short
    // to be correct for full credit
    // So I guess I'm gonna try to do the comparison manually? ._.
/* 
    // Initialize the result to be true
    boolean result = true;

    // Check to see if they have the same size(num of elements)
    if (tree1.size() != tree2.size()) {
      result = false;
    }

    // Create an iterator for tree1 to iterate over the entries of the tree1
    Iterator<Map.Entry<Integer, String>> i = tree1.entrySet().iterator();

    // Iterate through the tree1 while there is a next Node
    while (i.hasNext()) {

      // Get the <key, value> pair from the map
      Map.Entry<Integer, String> entery = i.next();

      // Compare tree1 with tree2
      if (!tree2.containsKey(entery.getKey()) || !tree2.get(entery.getKey()).equals(entery.getValue()))
        result = false;

    }
    return result;
 */
  }// Method treesEqual

} // end treeProblems class
