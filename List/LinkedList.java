//Simple LinkedList Program For Basic Operation
//Insertatin And Deletation
import java.util.*;

class Node{
	int data;
	Node next;
	public void Node(int value){
		data=value;
	}
}

class ListOfNode{
		Node first=null;
	Node Temp=new Node();
	public void display(){
		System.out.println(" 1.Insert at first ");
			System.out.println(" 2.Insert At Last ");
				System.out.println(" 3.Insert At any position");
					System.out.println(" 4. delete element of first");
							System.out.println(" 5.delete element in Last");
									System.out.println(" 6.Deleting Element At position");
										System.out.println(" 7.Traversing Of List ");
										System.out.println(" 8. for print reverse list");
											System.out.println(" Enter your choice");
		
		}
	

	//methods for Operation
public void InsertAtFirst(int a){
	Node A=new Node();
	A.data=a;
	A.next=first;
    first=A;
	}
		public void InsertAtLast(int a){
			Node A=new Node();
			A.data=a;
			if(first==null){
				first=A;
			}else{
				
				Node r=first;
				while(r.next!=null){
					r=r.next;
				}
				r.next=A;
			}
		}
		
		public void InsertAtPosition(int a,int i){
			int count=0;
			Node Temp=first;
			Node A=new Node();
			A.data=a;
			while((first!=null)&&(count<i-1)){
				first=first.next;
				count++;
			}
			if(count==0){
				A.next=first;
				first=A;
				Temp=first;
				
			}else{
			
			A.next=first.next;
			first.next=A;
			}
			first=Temp;
			
		}
		
		public void deleteFirst(){
			Node Temp1=first;
			first=first.next;
			
		}
		
		public void deleteLast(){//remember it ok
			Node r=first;
			while(r.next.next!=null){
				r=r.next;
			}
			r.next=null;
			
		}
		public void deleteAtPosition(int i){
			int count=1;
			Node r=first;
			while((r.next!=null)&&(count<i-1)){
				r=r.next;
				count++;
			}if((count==1)&&(i==1)){
				first=first.next;
				
			}else{
				
				r.next=r.next.next;
			}
			
			
		}
		
public void Traverse(){
	Node r=first;
	if(first==null){
		System.out.println("List is empty");
	}else{
		System.out.println("This is your List");
	while(r!=null){
		System.out.println(r.data);
		r=r.next;
	}
}}}
//main class
public class LinkedList{
	
	public static void main(String arg[]){
		ListOfNode object=new ListOfNode();
		Scanner input=new Scanner(System.in);
		
		object.display();
		int choice=input.nextInt();
		while(choice!=15){
			
		switch(choice){
			case 1:
			System.out.println("Enter you want to insert");
			int argument=input.nextInt();
		    object.InsertAtFirst(argument);	
			break;
			
			case 2:
			System.out.println("Enter your number want to insert");
			int argument1=input.nextInt();
		    object.InsertAtLast(argument1);	
			break;
			
			case 3:
			System.out.println("Enter your Position to Insert");
			int Position=input.nextInt();
			System.out.println("Enter your number want to insert");
			int argument2=input.nextInt();
		    object.InsertAtPosition(argument2,Position);	
			break;
			
            case 7:
			object.Traverse();	
			break;
			
			 case 4:
			object.deleteFirst();	
			break;
			
			 case 5:
			object.deleteLast();	
			break;
			 case 6:
			 System.out.println("Enter your Position to Delete");
			int Position1=input.nextInt();
			object.deleteAtPosition(Position1);	
			break;
			
			case 8:
			System.out.println("This is your reverse list");
			object.reverse();
			
		default:
				System.out.println(" please Enter Right choice");
	}
	object.display();
	choice=input.nextInt();
}
}}