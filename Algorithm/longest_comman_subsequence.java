import java.util.*;
public class longest_comman_subsequence {
	static char st[] =new char[50];
	 static int count=0;
	public static int dynamic(String s1,String s2,int l1,int l2){
		
		   int L[][]=new int[l1+1][l2+1];
		   int i, j;
		  
		   /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
		      that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
		   for (i=0; i<=l1; i++)
		   {
		     for (j=0; j<=l2; j++)
		     {
		       if (i == 0 || j == 0)
		         L[i][j] = 0;
		  
		       else if (s1.charAt(i-1) == s2.charAt(j-1)){
		         L[i][j] = L[i-1][j-1] + 1;
		       count++;
		       }
		       else
		         L[i][j] = find_max(L[i-1][j], L[i][j-1]);
		     }
		   }
		    
		   /* L[m][n] contains length of LCS for X[0..n-1] and Y[0..m-1] */
		   return L[l1][l2];
		}
	

public static int find_max(int a,int b){
	if(a>b){
		return a;
	}else{
		return b;
	}
}
public static String dynamic(String s1,String s2){
		
		
		return "alok";
	}
	
	
	
	
		public static void main(String arg[]){
			Scanner input=new Scanner(System.in);
			
			System.out.println("Enter first string");
			String  s1=input.nextLine();
			
			System.out.println("Enter second string");
			String s2=input.nextLine();
			int res=dynamic(s1,s2,s1.length(),s2.length());
			System.out.println("length="+res);
			System.out.println("count="+count);
			//for(int i=0;i<count;i++){
			//System.out.println("sustring ="+st[i]);
			//}
			dynamic(s1,s2);
			
		}
}
