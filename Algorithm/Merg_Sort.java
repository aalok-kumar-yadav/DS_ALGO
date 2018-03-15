import java.util.*;

public class Merg_Sort {
	
	
	public static void divide(int[] arr,int lf,int rt){
		

		if(lf<rt){
			int mid=(lf+rt)/2;
		divide(arr,lf,mid);
		divide(arr,mid+1,rt);
		merge_subArray(arr,lf,mid,rt);
		
		}
	}
	
	public static int[] merge_subArray(int[] arr,int lf,int mid ,int rt){
		int l1=mid-lf+1;
		int l2=rt-mid;
		
		int temp=lf;
		int f=0,d=0;
		
		int left[]= new int[l1];//creating two sub array left and right 
		
		int right[]=new int[l2];
		
		for(int i=0;i<l1;i++){
			left[i]=arr[lf+i];
		}
		for(int j=0;j<l2;j++){
			right[j]=arr[mid+1+j];
		}
		while(f<l1&&d<l2){
			if(left[f]<right[d]){
				arr[temp]=left[f];
				f++;
				temp++;
			}else{
				arr[temp]=right[d];
				d++;
				temp++;
			}
		}
		
		while(f<l1){
			arr[temp]=left[f];
			f++;
			temp++;
		}
		while(d<l2){
			arr[temp]=right[d];
			d++;
			temp++;
		}
		
		
		
	return arr;
	}

	public static void main(String arg[]){
		Scanner input=new Scanner(System.in);
		System.out.println("enter size of array for sorting ");
		int n=input.nextInt();
		int arr[]=new int[n];
		System.out.println("enter all element ");
		for(int i=0;i<n;i++){
			arr[i]=input.nextInt();
			
		}
		
	divide(arr,0,n-1);
	System.out.println("Sorted array is");
	for(int i=0;i<n;i++){
		System.out.print(arr[i]+" ");
	}
	
	}
}
