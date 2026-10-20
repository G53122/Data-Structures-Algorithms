import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);

      System.out.println("\n\nBubble sort results ----------------------------------------------");
      ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
      Lab4.outputList(bubbleSortedList);

      System.out.println("\n\nInsertion sort results -------------------------------------------");
      ArrayList<Integer> insertionSortedList = Lab4.insertionSort(integerList);  
      Lab4.outputList(insertionSortedList);
    }
}

class Lab4 {

  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {

  // Calculates start time for insertionSort algorithm. 
  long insertionSortStartTime = System.nanoTime();

      // Step 1 - Implement insertion sort algorithm here
    for (int i = 1; i < integerList.size(); i++) {
    int currentInt = integerList.get(i);
    int k;
      for (k = i - 1; k >= 0 && integerList.get(k) > currentInt; k--) {
        integerList.set(k, k + 1);
    }
    integerList.set(k + 1, currentInt);
  }
   // Calculates end time for insertionSort algorithm. 
  long insertionSortEndTime = System.nanoTime();

  // Calculates and outputs elapsed time for insertionSort algorithm.
  long insertionSortElapsedTime = insertionSortEndTime - insertionSortStartTime; 
  System.out.println("Execution time for insertion sort: " + insertionSortElapsedTime + " nanoseconds."); 
  
 return integerList;
}

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {

  // Calculates start time for bubbleSort algorithm. 
  long bubbleSortStartTime = System.nanoTime();
  
    // Step 2 - Implement the bubble sort algorithm here
    boolean needNextPass = true; 
    for (int a = 1; a < integerList.size() && needNextPass; a++) {
      needNextPass = false; 

      for (int b = 0; b < integerList.size() - a; b++) {
        if (integerList.get(b) > integerList.get(b + 1)){
          int tempArrayList = integerList.get(b);
          integerList.set(b, integerList.get(b + 1));
          integerList.set(b + 1, tempArrayList);

          needNextPass = true;
        }
      }
    }
  // Calculates end time for bubbleSort algorithm. 
  long bubbleSortEndTime = System.nanoTime();

  // Calculates and outputs elapsed time for bubbleSort algorithm.
  long bubbleSortElapsedTime = bubbleSortEndTime - bubbleSortStartTime; 
  System.out.println("Execution time for bubble sort: " + bubbleSortElapsedTime + " nanoseconds."); 
    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("Lab-4/integers.txt"))) {
      // Edited integers.txt to Lab-4/integers.txt due to file-not-found exception.
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
  }
}