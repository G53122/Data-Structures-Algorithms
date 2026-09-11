//import java.util.*;
/*
 * IT-2660 - Lab 1
 * Student Name: Grace Nazel
 */

public class Main {
  public static void main(String[] args) {
    int[] nums = {5, 9, 3, 12, 7, 3, 11, 5};
    System.out.println("hello, world!");
    Lab1 lab = new Lab1();
    System.out.println(lab.increment(1));
    System.out.println(lab.max(8, 127));
    System.out.println(lab.min(90, 46));
    System.out.println(lab.sum(nums));
    System.out.println(lab.average(nums));
    System.out.println(lab.max(nums));
    System.out.println(lab.min(nums));

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
    int length = nums.length;
    for(int i = 0; i < length; i++) {
      sum += i;
    }
    return sum;
  }
  public int average(int[] nums) {
    int avg;
    int sum = 0;
    int length = nums.length;
    for(int a : nums ) {
      sum += a;
    }
    avg = sum / length;
    return avg;
  }
  public int max(int[] nums){
  int max = nums[0];
  for(int n = 0; n > max; n++){
    max = n;
  }
  return max;
  }
  public int min(int[] nums){
    int min = nums[0];
    for(int n = 0; n < min; n++){
      min = n;
    }
    return min;
  }
}
}