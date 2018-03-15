//Basic Insert and Delete OPeration By Stack
//Implememntation By LinkedList And Array

import java.util.*;

//Class Format like Structure
class Node{
	int data;
	Node next;
	public void Node(int d){
		data=d;
	}
}

class ListOfNode{
	Node first=null;
	Node Temp =new Node();
	int Array[]=new int[100];
	int array[]=new int[100];
	//List of many methods Of Stack operation
	
	public void display(){
		System.out.println(" 1.Push Opperation By LinkedList");
		System.out.println(" 2.Pop Opration By LinkedList");
		System.out.println(" 3.Peak Operation By LinkedList");
		System.out.println(" 4. Traverse Of LinkedList Stack");
		
		System.out.println(" 5.Push Opperation By Array");
		System.out.println(" 6.Pop Opration Array");
		System.out.println(" 7.Peak Operation Array");
		System.out.println(" 8.Traverse Operation Of Array Stack");
		
		
		System.out.println(" Enter Your Choice");
	}
	
	public void push(int a){
		
		Node A=new Node();
		A.data=a;
		
		A.next=first;
		first=A;
	}
	
	public void pop(){
		
		first=first.next;
	}
	
	public void peak(){
		
		Node Temp=first;
		first=first.next;
		System.out.println(Temp.data);
		
	}
	
	public void Traverse(){
	Node r=first;
	if(first==null){
		System.out.println();
		System.out.println("List is empty");
	}else{
				System.out.println();
		System.out.println("This is your List");
	while(r!=null){
		System.out.println(r.data);
		r=r.next;
	}
}}
	
	public void pushArray(int a,int b){
		
			
		 Array[b]=a;
		
		
	}
	public void popArray(int b){
		
		b--;
	}
	
	public void peakArray(int b){
		System.out.println(Array[b]);
	}
	public void TraverseArray(int c){
		int b=0;
		 
		while(b<c){
			array[b]=Array[b];
			System.out.println(array[b]);
			b++;
		}
	}
	
}
//Main class And methods
 class stackOperation{
	 public static void main(String arg[]){
		 ListOfNode object=new ListOfNode();
		 Scanner input=new Scanner(System.in);
				int count=0;
		object.display();
		int choice=input.nextInt();
		while(choice!=15){
	
		switch(choice){
			case 1:
			System.out.println("Enter number you want to insert");
			int argument=input.nextInt();
			object.push(argument);
			break;
			
			case 2:
			object.pop();
			break;
			
			case 3:
			object.peak();
			break;
			
			case 4:
			object.Traverse();
			break;
			
			case 5:
			System.out.println("Enter number you want to insert in Array FOrmat");
			int argument1=input.nextInt();
			object.pushArray(argument1,count);
			count++;
			break;
			
			case 6:
					System.out.println("you r in case 6");
			object.popArray(count);
			count--;
			break;
			
			case 7:
			count--;
					System.out.println("you r in case 7");
			object.peakArray(count);
			break;
			
			case 8:
			
			System.out.println("you r in Traverse Array");
			object.TraverseArray(count);
			break;
			
			default:
			System.out.println(" please Enter Right choice");
	}
	object.display();
	choice=input.nextInt();
}

	 }
 }