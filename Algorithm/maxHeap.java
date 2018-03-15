import java.util.*;

 
 
   class Heap{
	  
	int heap[]=new int[20];
	int heapCopy[]=new int[20];

	public void max_heap(int item,int i){
	if(i==1){
		heap[i]=item;
	}
	else{
	while((i!=1)&&(item>heap[i/2])){
		heap[i]=heap[i/2];
		i/=2;
	}
	heap[i]=item;
	
	
}
	}
	
	public void heap_sort(int size){
		int h=0;
		while(size!=0){
		int temp=heap[size];
		heap[size]=heap[h];
		temp=heap[size];
		size--;
		max_heap_sorting(temp,size);
		}
	}
public  max_ heap_sort(int heapCopy,int s){
	
}
	
	
public void traverse(int c){
	System.out.println("This is your List");
	for(int j=1;j<=c;j++){
		
	System.out.println(heap[j]);
	
}}
 }

class maxHeap{
	public static void main(String arg[]){
		Heap object=new Heap();
		Scanner input=new Scanner(System.in);
		System.out.println("1. for insert  ");
	 System.out.println("2. for traversing");
	 	System.out.println("3. for sorting");
		int choice=input.nextInt();
		
		int count=1;
	while(choice!=8){
		switch(choice){
			
		case 1:
		System.out.println("Enter your number to insert");
		int data=input.nextInt();
		object.max_heap(data,count);
		count++;
		break;
		
		case 2:
		object.traverse(count);
		break;
		
		case 3:
		object.heap_sort(count);
		break;
		
		default:
		System.out.println("Enter right choice");
		
		}
	System.out.println("1. for insert  ");
	System.out.println("2. for traversing");
		System.out.println("3. for sorting");
		 choice=input.nextInt();
		
	}
}
}