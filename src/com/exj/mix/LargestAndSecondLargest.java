package com.exj.mix;

/**
 * Finds the largest and second largest elements using minimum number of comparisons.
 * n + logn -2 comparisons
 * @author johns
 *
 */

public class LargestAndSecondLargest {
	static int[] maximum(int i, int j, int[] Arr, int n){
		
		int[] comparisons = new int [n];
		if(i == j){
			comparisons[0] = 1;
			comparisons[1] = Arr[i];
			return comparisons;
		}
		
		int mid = (i+j)/2; int len = 0;
		int[] comparisons1 = maximum(i, mid, Arr, n);
		int[] comparisons2 = maximum(mid+1, j, Arr, n);
		
		if(comparisons1[1] > comparisons2[1]){
			len = comparisons1[0] + 1;
			comparisons1[len] = comparisons2[1];
			comparisons1[0] = len;
			return comparisons1;
		}else{
			len = comparisons2[0] + 1;
			comparisons2[len] = comparisons1[1];
			comparisons2[0] = len;
			return comparisons2;
		}
	}
	
	public static void main(String[] args) {
		int Arr[] = {16, -1, 7, 5, 12, 1, 0, 4};
		int largest[] = maximum(0, Arr.length-1, Arr, Arr.length);
		int secLargest[] = maximum(2, largest[0], largest, largest[0]);
		System.out.println("The largest element is : "+largest[1]);
		System.out.println("The second largest element is : "+secLargest[1]);
	}
}
