package com.exj.mix;

public class KthSmallestNumber {
	public static int partition(int arr[], int beg, int end) {
		int pivot = arr[end];
		int index = beg;
		for (int i = beg; i < end; i++) {
			if (arr[i] <= pivot) {
				swap(arr, i, index);
				index++;
			}
		}
		swap(arr, index, end);
		return index;
	}

	public static void swap(int arr[], int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

	public static int findKthSmallest(int arr[], int beg, int end, int k) {
		int n = arr.length;
		if (beg <= end) {
			int pos = partition(arr, beg, end);
			if (pos + 1 == k) {
				return pos;
			} else if (pos + 1 > k) {
				return findKthSmallest(arr, beg, pos - 1, k);
			} else {
				return findKthSmallest(arr, pos + 1, end, k);
			}
		}

		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 7, 3, 2, 6, 4 };
		System.out.println(arr[findKthSmallest(arr, 0, arr.length-1, 4)]);
	}
}
