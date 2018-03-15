import java.util.*;
import java.io.*;
public class bubble_sort {
	public static void main(String arg[])throws IOException{
		int arr[]=new int[1500];
		try{
		FileReader file = new FileReader(new File("C:/Users/Aalok Kumar/Desktop/numbers.dat"));
		BufferedReader br = new BufferedReader(file);
		for(int i=0;i<1500;i++){
			String  val = br.readLine();
			int a=Integer.parseInt(val);
		
			arr[i]=a;
		}
		
		
		}catch(FileNotFoundException e){
			
			System.out.println(e);
		}
		double startTime = System.currentTimeMillis();
		
		//algorithms  for bubble sort
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j+1]<arr[j]){
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
	
				}
			}
		}
		double endTime = System.currentTimeMillis();
		System.out.println("time taken=");
		double t=endTime-startTime;
		System.out.printf("%.5f",t);
		System.out.println();
		System.out.println("Sorted Input Are->>");
	
		for(int k=0;k<arr.length;k++){
			System.out.println(arr[k]);
		}
		
	}
}
