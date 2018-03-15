import java.util.*;
public class quick_sort {
	
	public static void sort_array(int arr[],int l,int r){ //here base condition of recursion is pending
		if(l<r)
		{
		int pvt=correct_pivot(arr,l,r);
		sort_array(arr,l,pvt-1);
		sort_array(arr,pvt+1,r);
		
		}
	  }
	public static int correct_pivot(int[] arr,int l,int r )
	{
		int pv=arr[r];
		int ptr=l;
		for(int i=l;i<=r;i++)
		{
			if(arr[i]<=pv)
			{
				int temp=arr[i];
				arr[i]=arr[ptr];
				arr[ptr]=temp;
				ptr++;
			}
		}
		ptr--;
		arr[ptr]=pv;
		return ptr;
	}
	
	public static void main(String arg[])
	{
		Scanner input=new Scanner(System.in);
		System.out.println("enter size of array for sorting ");
		int n=input.nextInt();
		int arr[]=new int[n];
		System.out.println("enter all element ");
		for(int i=0;i<n;i++)
		{
			arr[i]=input.nextInt();
			
		}
		
		sort_array(arr,0,n-1);
	System.out.println("Sorted array is");
	for(int i=0;i<n;i++)
	{
		System.out.print(arr[i]+" ");
	}
	
	}
}
