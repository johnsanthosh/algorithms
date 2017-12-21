package com.exj.dynamicprogramming;

/**
 * Let G = (V,E) be an undirected graph with n nodes. Recall that a subset of the
 * nodes is called an independent set if no two of them are joined by an edge.
 * Find an independent set in graph G whose total weight is as large as possible.
 * @author johns
 *
 */
public class MaximumWeightIndependentSet {
	
	static int findIndependentSetWithMaximumWeight(int arr[]){
		int len = arr.length;
	
		if(len == 0){
			return 0;
		}
		
		if(len == 1){
			return arr[0];
		}
		
		int count[] = new int[len];
		int seq[] = new int[len];
		
		count[0] = arr[0];
		count[1] = arr[1];
		int maxpos = 0;
		int max = 0;
		if(count[0]>count[1]){
			max = count[0];
			maxpos = 0;
		}else{
			max = count[1];
			maxpos = 1;
		}
		
		
		for(int i=0; i<len; i++){
			seq[i] = i;
		}
		
		for(int i=2; i<len ; i++){
			int temp = (i-3 < 0)? -1 : count[i-3]; 
			if(count[i-2] > temp){
				count[i] = count[i-2] + arr[i];
				seq[i] = i-2;
			}else{
				count[i] = temp + arr[i];
				seq[i] = i-3;
			}
			max = Math.max(max, count[i]);
			maxpos = i;
		}
		
		int current = maxpos;
		int next = maxpos;
		System.out.println("Max Weight Independent Sequence : ");
		do{
			current = next;
			System.out.print(arr[current] + " ");
			next = seq[current];
		}while(current != next);
		System.out.println();
		
		return max;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 8, 6, 3, 6};
		System.out.println("Max Sum : "+MaximumWeightIndependentSet.findIndependentSetWithMaximumWeight(arr));
	}
}
