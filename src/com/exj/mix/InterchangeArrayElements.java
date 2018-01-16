package com.exj.mix;
/**
 * Let T be an array of n one-dimensional elements.
 * Interchange the first k and the last n-k elements, without making use of an auxiliary array.
 * @author johns
 *
 */
public class InterchangeArrayElements {
   private void reverse(int arr[], int beg, int end){
	   int temp;
	   for(int i=beg, j=end; i<j; i++, j--){
		   temp = arr[i];
		   arr[i]= arr[j];
		   arr[j] = temp;
	   }
   }
   
   public static void main(String[] args) {
     int arr[] = {1, 2, 3, 4, 5, 6};
     int n = arr.length;
     int k = 3;
     InterchangeArrayElements obj = new InterchangeArrayElements();
     obj.reverse(arr, 0, n-1);
     obj.reverse(arr, n-k, n-1);
     obj.reverse(arr, 0, n-k-1);
     
     for(int i : arr){
    	 System.out.print(i + " ");
     }
     
     
   }
}
