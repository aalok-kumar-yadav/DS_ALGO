import java.util.*;
public class insertion_sort {
	public static void main(String arg[]){
		Scanner input=new Scanner(System.in);
		System.out.println("Enter size of array");
		int n=input.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=input.nextInt();
		}
		//algorithm of insertion sort
		for(int i=1;i<n;i++){
			for(int j=i;j>0;j--){
				if(arr[j]<arr[j-1]){
					int temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}else{
					break;
				}
			}
		}
		for(int k=0;k<n;k++){
			System.out.println(arr[k]);
		}
		
	}
}
