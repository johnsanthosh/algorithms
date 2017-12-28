package com.exj.mix;

/**
 * You’re given an array A consisting of n integers A[1], A[2], …., A[n].
 * You’d like to output a 2-dimensional n by n array B, in which B[i, j]
 * (for i < j), contains the sum of array entries A[i] through A[j]- that is,
 * the sum A[i] + A[i+1] + …. + A[j]. The value of array entry B[i, j], 
 * is left unspecified whenever i >= j. 
 * Hence, it does not matter what the output is for these values.
 * @author johns
 *
 */
public class MatrixSumProblem {
	public static void main(String[] args) {
		int a1[] = {1,2,3,4,5};
		int length = a1.length;
		int a2[][] = new int[length][length];
		
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++){
				if(i<j-1){
					a2[i][j] = a2[i][j-1]+a1[j];
				}
				else{
					a2[i][j]=a1[i]+a1[j];
				}
			}
		}
		
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				System.out.print(a2[i][j]+" ");
			}
			System.out.println();
		}
	}
}
