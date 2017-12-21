package com.exj.dynamicprogramming;

/**
 * Given two sequences of characters.
 * PrintW all longest common subsequences.
 * @author johns
 *
 */
public class AllLongestCommonSubsequences {
	
	public void findAllLongestCommonSubsequences(char p[], char q[]){
		int m = p.length;
		int n = q.length;
		int count[][] = new int[m+1][n+1];
		char order[][] = new char[m+1][n+1];
		
		for(int i=0; i<=m; i++){
			count[i][0] = 0;
		}
		
		for(int i=0; i<=n; i++){
			count[0][i] = 0;
		}
		
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if(p[i-1] == q[j-1]){
					count[i][j] = count[i-1][j-1]+1;
					order[i][j] = '\\';
				}else{
					if(count[i-1][j] > count[i][j-1]){
						count[i][j] = count[i-1][j];
						order[i][j] = '^';
					}else if(count[i][j-1] > count[i-1][j]){
						count[i][j] = count[i][j-1];
						order[i][j] = '<';
					}else{
						count[i][j] = count[i][j-1];
						order[i][j] = '*';
					}
				}
			}
		}
		
		System.out.println("Length of the longest common subsequence : "+count[m][n]);
		System.out.println("The longest common subsequence : ");
		printLongestCommonSubsequence(p, order, m ,n);
		
	}
	
	public void printLongestCommonSubsequence(char p[], char order[][], int m, int n ){
		if(m==0 || n==0)
			return;
		
		if(order[m][n] == '\\'){
			System.out.print(p[m-1]);
			printLongestCommonSubsequence(p, order, m-1, n-1);
		}else if(order[m][n] == '^'){
			printLongestCommonSubsequence(p, order, m-1, n);
		}else if(order[m][n] == '<'){
			printLongestCommonSubsequence(p, order, m, n-1);
		}else{
			System.out.print(" ");
			printLongestCommonSubsequence(p, order, m, n-1);
			System.out.print("/");
			printLongestCommonSubsequence(p, order, m-1, n);
		}
	}
	
	public static void main(String[] args) {
		char p[] = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
		char q[] = {'B', 'D', 'C', 'A', 'B', 'A'};
		
		AllLongestCommonSubsequences obj = new AllLongestCommonSubsequences();
		obj.findAllLongestCommonSubsequences(p, q);
	}
	
}
