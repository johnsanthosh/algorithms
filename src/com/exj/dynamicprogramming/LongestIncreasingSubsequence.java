package com.exj.dynamicprogramming;

/**
 * Let S be an ordered sequence of n distinct integers. Develop an algorithm to
 * find a longest increasing subsequence of the entries of S. The subsequence is
 * not required to be contiguous in the original sequence. For example, if S =
 * {11, 17, 5, 8, 6, 4, 7, 12, 3}, a longest increasing subsequence of S is {5,
 * 6, 7, 12}.
 * 
 * @author john
 *
 * Time complexity is O(n^2).
 * Space complexity is O(n)
 *
 */

public class LongestIncreasingSubsequence {

	int findLongestIncreasingSubsequence(int a[]) {
		int len = a.length;
		int count[] = new int[len];
		int sequence[] = new int[len];

		for (int i = 0; i < len; i++) {
			count[i] = 1;
			sequence[i] = i;
		}

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if ((a[j] < a[i]) && (count[j] + 1 > count[i])) {
					count[i] = count[j] + 1;
					sequence[i] = j;
				}
			}
		}
		
		//Finds max and maxpos
		int max = count[0];
		int maxPos = 0;
		for (int i = 1; i < len; i++) {
			if (max < count[i]) {
				max = count[i];
				maxPos = i;
			}
		}
		
		//Prints longest increasing subsequence
		int currentElement = maxPos;
		int nextElement = maxPos;
		System.out.println("Longest Increasing Subsequence : ");
		do {
			currentElement = nextElement;
			System.out.print(a[currentElement] + " ");
			nextElement = sequence[currentElement];

		} while (currentElement != nextElement);
		System.out.println("");

		return max;
	}

	public static void main(String[] args) {
		// int a[] = { 11, 17, 5, 8, 6, 4, 7, 12, 3 };
		int a[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		System.out.println(obj.findLongestIncreasingSubsequence(a));
	}
}
