import java.util.*;

public class selection_sort {
	
	public static void main(String arg[]){
		Scanner input=new Scanner(System.in);
		System.out.println("Enter size of array");
		int n=input.nextInt();
		int arr[]=new int[n];
		for(int k=0;k<n;k++){
			arr[k]=input.nextInt();
			
		}
		//selection sort
		for(int i=0;i<n-1;i++){
			int min=arr[i];
			int cp=0;
			for(int j=i+1;j<n;j++){
				if(arr[j]<min){
					min=arr[j];
					cp=j;
				}
			}
			
		if(cp!=0){
			int temp=arr[cp];
			arr[cp]=arr[i];
			arr[i]=temp;
		}
			
		}
		
		
		for(int h=0;h<n;h++){
			
			
			System.out.print(arr[h]+" ");
			
		}
		System.out.println();
	}
}
