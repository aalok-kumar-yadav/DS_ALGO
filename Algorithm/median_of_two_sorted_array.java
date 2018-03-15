import java.util.*;
public class median_of_two_sorted_array {//both approaches naive and dynamic programming
	public static int merge_based(int arr1[],int arr2[]){		
		int i=0;
		int j=0;
		int m1=0;
		int m2=0;
		
		for(int c=0;c<arr1.length;c++){
	if(i==arr1.length){
		m1=arr1[arr1.length-1];
		m2=arr2[0];
		break;
		
	}else{
		if(j==arr1.length){
			m1=arr2[arr1.length-1];
			m2=arr1[0];
		break;
			
		}
	}
		
		
		if(arr1[i]<arr2[j]){
			m1=m2;
			m2=arr1[i];
			i++;
		}
		else if(arr1[i]>arr2[j]){
			m1=m2;
			m2=arr2[i];
			j++;
		}
		}
		return (m1+m2)/2;
		
		
	}

	
	
	
	public static void main(String arg[]){
		
		Scanner input=new Scanner(System.in);
		System.out.println("Enter size of first sorted array");
		int n1=input.nextInt();
		int arr1[]=new int[n1];
		System.out.println("Enter Element of first array");
		for(int i=0;i<n1;i++){
			arr1[i]=input.nextInt();
		}
		int arr2[]=new int[n1];
		System.out.println("Enter Element of second array");
		for(int i=0;i<n1;i++){
		arr2[i]=input.nextInt();
		}
		int res=merge_based(arr1,arr2);
		System.out.println("median of two sorted array  is="+res);
		
	}
}
