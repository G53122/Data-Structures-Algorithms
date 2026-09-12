//import java.util.*//
/*
 * IT-2660 - Lab 1
 * Student Name: Grace Nazel
 */

public class Main {
  public void main(String[] args) { /* Note: the word static was removed to resolve an error code. */ 
    int[] nums = {5, 9, 3, 12, 7, 3, 11, 5};

    int w = 0;
    while(w < nums.length) {
    System.out.println(nums[w]);
    w++; } //working

    for(int i = nums.length; i > 0; i--) {
    System.out.println(nums[i-1]); }

    System.out.println(nums[0]); //working
    System.out.println(nums[nums.length - 1]); //working


    System.out.println("hello, world!");
    Lab1 lab = new Lab1();
    System.out.println(lab.increment(1)); //working
    System.out.println(lab.max(8, 127)); //working
    System.out.println(lab.min(90, 46)); //working
    System.out.println(lab.sum(nums)); //working
    System.out.println(lab.average(nums)); //working
    System.out.println(lab.max(nums)); //working
    System.out.println(lab.min(nums)); //working

}     

// Add all of the methods here
class Lab1 {
  public int increment(int num) {
    return ++num;
  }
  public int max(int a, int b) {
    if (a > b) {
        return a;
    }
    else {
        return b;
    }
  }

  public int min(int a, int b) {
    if (a < b) {
        return a;
    }
    else {
        return b;
    }
  }

  public int sum(int[] nums) {
    int sum = 0;
    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    return sum;
  }
  public float average(int[] nums) {
    float avg;
    float sum = 0;
    float length = nums.length;
    for(int a : nums ) {
      sum += a;
    }
    avg = sum / length;
    return avg;
  }

  public int max(int[] nums){
  int max = nums[0];
  for(int x = 0; x < nums.length; x++){
    if (nums[x] > max){
      max = nums[x];
    }
   }
  return max;
  }

  public int min(int[] nums){
    int min = nums[0];
    for(int y = 0; y < nums.length; y++){
      if (nums[y] < min){
        min = nums[y];
      }
    }
    return min;
}
}
}
