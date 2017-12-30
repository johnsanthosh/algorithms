package com.exj.mix;

/*
 * Suppose we are given two sets of n points, one set {p1,p2, . . . , pn} on the line y = 0 and
the other set {q1,q2, . . . , qn} on the line y = 1. Consider the n line segments connecting
each point pi to the corresponding point qi. Describe and analyze a divide-and-conquer
algorithm to determine how many pairs of these line segments intersect, in O(n log n) time.
 * 
 */
public class IntersectingPoints {
	public static void merge(int P[], int Q[], int beg, int mid, int end){
		int l1 = mid - beg + 1;
		int l2 = end - mid;
		
		int B[] = new int[l1];
		int C[] = new int[l2];
		
		int D[] = new int[l1];
		int E[] = new int[l2];
		
		for(int i = 0; i < l1; i++){
			B[i] = P[beg + i];
			D[i] = Q[beg + i];
		}
		
		for(int j = 0; j < l2; j++){
			C[j] = P[mid+1+j];
			E[j] = Q[mid+1+j];
		}
		
		int b = 0, c = 0, k=beg;
		while(b<l1 && c<l2){
			if(B[b] < C[c]){
				P[k] = B[b];
				Q[k] = D[b];
				b++;
			}else{
				P[k] = C[c];
				Q[k] = E[c];
				c++;
			}
			k++;
		}
		
		while(b<l1){
			P[k] = B[b];
			Q[k] = D[b];
			b++;
			k++;
		}
		
		while(c<l2){
			P[k] = C[c];
			Q[k] = E[c];
			c++;
			k++;
		}	
	}
	
	public static void sort(int P[],int Q[], int beg, int end){
		if(beg < end){
			int mid = (beg + end) / 2;
			sort(P, Q, beg, mid);
			sort(P, Q, mid+1, end);
			merge(P, Q, beg, mid, end);
		}
	}
	
	public static int mergeAndCountInversions(int A[], int beg, int mid, int end){
		int count = 0;
		int l1 = mid - beg + 1;
		int l2 = end - mid;
		
		int B[] = new int[l1];
		int C[] = new int[l2];
		
		for(int i = 0; i < l1; i++){
			B[i] = A[beg + i];
		}
		
		for(int j = 0; j < l2; j++){
			C[j] = A[mid+1+j];
		}
		
		int b = 0, c = 0, k=beg;
		while(b<l1 && c<l2){
			if(B[b] < C[c]){
				A[k] = B[b];
				b++;
			}else{
				count += l1-b;
				A[k] = C[c];
				c++;
			}
			k++;
		}
		
		while(b<l1){
			A[k] = B[b];
			b++;
			k++;
		}
		
		while(c<l2){
			A[k] = C[c];
			c++;
			k++;
		}	
		
		return count;
	}
	
	public static int sort(int A[], int beg, int end){
		if(beg < end){
			int count = 0;
			int mid = (beg + end) / 2;
			count += sort(A, beg, mid);
			count += sort(A, mid+1, end);
			return count + mergeAndCountInversions(A, beg, mid, end);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int P[] = {1, 7, 5, 3, 2};
		int Q[] = {3, 4, 2, 5, 6};
		sort(P, Q, 0, P.length-1);
		System.out.println(sort(Q, 0, Q.length-1));
	}
}
